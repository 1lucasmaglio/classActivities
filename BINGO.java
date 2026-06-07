import java.util.Scanner;
import java.util.Random;

public class Bingo {
    public static void main(String args[]) {
        int number;
        int option = 0;
        int bingo[] = new int[76]; // Indices 1 to 75
        Scanner input = new Scanner(System.in);
        Random R = new Random();
        char[] letters = "BINGO".toCharArray();

        // Initialize the board (optional, since int[] already starts with 0)
        for (int i = 0; i < 76; i++) bingo[i] = 0;

        System.out.println("=== BINGO SYSTEM ===");

        while (option != 3) {
            System.out.print("\n1: Draw | 2: List | 3: END\nENTER: ");
            option = input.nextInt();

            if (option == 1) {
                // Logic to avoid repeated numbers in the draw
                do {
                    number = 1 + R.nextInt(75);
                } while (bingo[number] == 1); 

                bingo[number] = 1;
                
                // Find the corresponding letter: 1-15(B), 16-30(I), etc.
                char drawnLetter = letters[(number - 1) / 15];
                System.out.printf("\n>>> DRAWN NUMBER: %c%02d <<<\n", drawnLetter, number);
            }

            if (option == 2) {
                listing(bingo, letters);
            }
        }
        input.close();
    }

    public static void listing(int[] B, char[] letters) {
        System.out.println("\n--- CURRENT BOARD ---");
        
        for (int l = 0; l < 5; l++) { // For each letter (B, I, N, G, O)
            System.out.print(letters[l] + ": ");
            
            for (int i = 1; i < 76; i++) {
                // Checks if the number belongs to the current letter range AND if it was drawn
                if ((i - 1) / 15 == l) {
                    if (B[i] == 1) {
                        System.out.printf("%02d ", i);
                    } else {
                        System.out.print("-- "); // Marker for numbers not drawn
                    }
                }
            }
            System.out.println(); // Jump to the next letter
        }
    }
}
