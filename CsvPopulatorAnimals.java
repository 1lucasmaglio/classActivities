/*
 * =========================================
 * File Name: CsvPopulatorAnimals
 * Members:
 * Thiago Alexandre Marques Basilio
 * Thiago Santos de Almeida
 * Lucas Maglio Chiabai
 * Yann Sahmuel Escobar de Campos
 * Date: 05/21/2026
 * Version: 1.0
 * Description: Animal populator for a .csv file that will be used as a database
 * =========================================
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class CsvPopulatorAnimals {

    private static final String filePath = "registros.csv";
    private static final String[] names = {
            "Raika", "Maltisetungue", "Repolhão", "Pipoca", "Flor", "Magrelo", "Neguinho", "Caramelo", "Rex", "Yann",
            "Bingo", "Ricardinho", "Cocozinho", "Cuscuz", "Daisy", "Tobinha", "Rambo", "Jack", "Zara", "Leo",
            "Nafitalina", "Cruzgredo", "Pingolinha", "Daisiane", "Inaladora", "Peco"
    };
    private static final String[] breeds = {
            "Labrador", "Golden Retriever", "Bulldog", "Poodle", "Beagle",
            "Rottweiler", "Yorkshire", "Husky", "Dachshund", "Shih Tzu",
            "Boxer", "Dobermann", "Pastor Alemão", "Dálmata", "Chow Chow",
            "Pinscher", "Maltês", "Akita", "Border Collie", "Cocker Spaniel",
            "Schnauzer", "Lhasa Apso", "Basset Hound", "Pitbull", "Weimaraner",
            "São Bernardo"
    };

    public static void populateCsvFile() {
        Random random = new Random();

        try (FileWriter writer = new FileWriter(filePath, true)) {
            for (int i = 0; i < 50; i++) {
                String name = names[random.nextInt(names.length)];
                String breed = breeds[random.nextInt(breeds.length)];
                int age = random.nextInt(20) + 1; // Age between 1 and 20

                writer.append(name).append(",")
                        .append(breed).append(",")
                        .append(String.valueOf(age)).append(" years").append("\n");
            }
            JOptionPane.showMessageDialog(null, "50 random animal records added successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        populateCsvFile();
    }
}
