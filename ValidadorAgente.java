import java.util.Scanner;

public class ValidadorAgente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your Codename: ");
        String codinome = scanner.nextLine();

        // TODO: Create regex for codename
        String regexCodinome = "^Agente-[A-Z]{3}$"; 

        if (codinome.matches(regexCodinome)) {
            System.out.println("Valid codename!");
        } else {
            System.out.println("Invalid codename!");
        }

        System.out.print("Enter your Password: ");
        String senha = scanner.nextLine();

        // TODO: Create regex for password
        String regexSenha = "^\\d{4, 6}$"; 

        if (senha.matches(regexSenha)) {
            System.out.println("Valid password!");
        } else {
            System.out.println("Invalid password!");
        }

        scanner.close();
    }
}
