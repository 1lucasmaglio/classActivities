import java.util.Scanner;

public class ValidadorAgente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu Codinome: ");
        String codinome = scanner.nextLine();

        // TODO: Criar a regex para o codinome
        String regexCodinome = "^Agente-[A-Z]{3}$"; 

        if (codinome.matches(regexCodinome)) {
            System.out.println("Codinome válido!");
        } else {
            System.out.println("Codinome inválido!");
        }

        System.out.print("Digite sua Senha: ");
        String senha = scanner.nextLine();

        // TODO: Criar a regex para a senha
        String regexSenha = "^\\d{4, 6}$"; 

        if (senha.matches(regexSenha)) {
            System.out.println("Senha válida!");
        } else {
            System.out.println("Senha inválida!");
        }

        scanner.close();
    }
}
