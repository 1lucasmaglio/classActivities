/*
 * =========================================
 * Nome do Arquivo: CsvPopulatorAnimais
 * Integrantes:
 * Thiago Alexandre Marques Basilio
 * Thiago Santos de Almeida
 * Lucas Maglio Chiabai
 * Yann Sahmuel Escobar de Campos
 * Data: 21/05/2026
 * Versão: 1.0
 * Descrição: Populador de animais para um arquivo .csv que será usado como um banco de dados
 * =========================================
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class CsvPopulatorAnimais {

    private static final String filePath = "registros.csv";
    private static final String[] nomes = {
            "Raika", "Maltisetungue", "Repolhão", "Pipoca", "Flor", "Magrelo", "Neguinho", "Caramelo", "Rex", "Yann",
            "Bingo", "Ricardinho", "Cocozinho", "Cuscuz", "Daisy", "Tobinha", "Rambo", "Jack", "Zara", "Leo",
            "Nafitalina", "Cruzgredo", "Pingolinha", "Daisiane", "Inaladora", "Peco"
    };
    private static final String[] racas = {
            "Labrador", "Golden Retriever", "Bulldog", "Poodle", "Beagle",
            "Rottweiler", "Yorkshire", "Husky", "Dachshund", "Shih Tzu",
            "Boxer", "Dobermann", "Pastor Alemão", "Dálmata", "Chow Chow",
            "Pinscher", "Maltês", "Akita", "Border Collie", "Cocker Spaniel",
            "Schnauzer", "Lhasa Apso", "Basset Hound", "Pitbull", "Weimaraner",
            "São Bernardo"
    };

    public static void popularArquivoCsv() {
        Random random = new Random();

        try (FileWriter writer = new FileWriter(filePath, true)) {
            for (int i = 0; i < 50; i++) {
                String nome = nomes[random.nextInt(nomes.length)];
                String raca = racas[random.nextInt(racas.length)];
                int idade = random.nextInt(20) + 1; // Idade entre 1 e 20

                writer.append(nome).append(",")
                        .append(raca).append(",")
                        .append(String.valueOf(idade)).append(" anos").append("\n");
            }
            JOptionPane.showMessageDialog(null, "50 registros de animais aleatórios adicionados com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        popularArquivoCsv();
    }
}
