/*
 * =========================================
 * File Name: CrudMenuCsvAnimals
 * Members:
 * Thiago Alexandre Marques Basilio
 * Thiago Santos de Almeida
 * Lucas Maglio Chiabai
 * Yann Sahmuel Escobar de Campos
 * Date: 05/21/2026
 * Version: 1.0
 * Description: Crud Menu to register animals
 * =========================================
 */

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrudMenuCsvAnimals {

    private static final String filePath = "registros.csv";

    public static void main(String[] args) {

        while (true) {

            String[] options = {"Add", "List", "Update", "Remove", "Exit"};

            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option",
                    "CRUD Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0 -> addRecord();
                case 1 -> listRecords();
                case 2 -> updateRecord();
                case 3 -> removeRecord();
                case 4 -> {
                    JOptionPane.showMessageDialog(null, "Closing the program.");
                    System.exit(0);
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }

    private static void addRecord() {

        String name = JOptionPane.showInputDialog("Enter the name:");
        String weight = JOptionPane.showInputDialog("Enter the weight (KG):");
        String breed = JOptionPane.showInputDialog("Enter the breed:");

        try (FileWriter writer = new FileWriter(filePath, true)) {

            writer.append(name).append(",").append(weight).append(",").append(breed).append("\n");

            JOptionPane.showMessageDialog(null, "Record added successfully!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file.");
            e.printStackTrace();
        }
    }

    private static void listRecords() {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            StringBuilder records = new StringBuilder("Records:\n");

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                records.append("Name: ").append(data[0])
                        .append(" | Weight: ").append(data[1]).append(" KG")
                        .append(" | Breed: ").append(data[2])
                        .append("\n");
            }

            JOptionPane.showMessageDialog(null, records.toString());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading the file.");
            e.printStackTrace();
        }
    }

    private static void updateRecord() {

        List<String> records = readRecords();

        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No records found.");
            return;
        }

        String searchName = JOptionPane.showInputDialog("Enter the name of the record to be updated:");

        boolean found = false;

        for (int i = 0; i < records.size(); i++) {

            String[] data = records.get(i).split(",");

            if (data[0].equalsIgnoreCase(searchName)) {

                String newName = JOptionPane.showInputDialog("Enter the new name:", data[0]);
                String newWeight = JOptionPane.showInputDialog("Enter the new weight (KG):", data[1]);
                String newBreed = JOptionPane.showInputDialog("Enter the new breed:", data[2]);

                records.set(i, newName + "," + newWeight + "," + newBreed);

                found = true;
                break;
            }
        }

        if (found) {
            writeRecords(records);
            JOptionPane.showMessageDialog(null, "Record updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Record not found.");
        }
    }

    private static void removeRecord() {

        List<String> records = readRecords();

        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No records found.");
            return;
        }

        String searchName = JOptionPane.showInputDialog("Enter the name of the record to be removed:");

        boolean found = records.removeIf(record ->
                record.split(",")[0].equalsIgnoreCase(searchName));

        if (found) {
            writeRecords(records);
            JOptionPane.showMessageDialog(null, "Record removed successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Record not found.");
        }
    }

    private static List<String> readRecords() {

        List<String> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                records.add(line);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading the file.");
            e.printStackTrace();
        }

        return records;
    }

    private static void writeRecords(List<String> records) {

        try (FileWriter writer = new FileWriter(filePath)) {

            for (String record : records) {
                writer.append(record).append("\n");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file.");
            e.printStackTrace();
        }
    }
}
