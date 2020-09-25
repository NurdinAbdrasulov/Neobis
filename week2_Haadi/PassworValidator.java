import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int uppercase = 0;
        int lowercase = 0;
        int digit = 0;
        int all;


        while (scan.hasNext()) {
            String check = scan.nextLine();
            if (check.contains(" ") || check.length() > 32 || check.length() < 6) {
                System.out.println("Senha invalida.");
            }
            else {
                for (int i = 0; i < check.length(); i++) {
                    if (Character.isUpperCase(check.charAt(i))) {
                        uppercase++;
                    }
                    if (Character.isLowerCase(check.charAt(i))) {
                        lowercase++;
                    }
                    if (Character.isDigit(check.charAt(i))) {
                        digit++;
                    }
                }
                all = lowercase + uppercase + digit;
                if (uppercase == 0
                        || lowercase == 0
                        || digit == 0
                        || all != check.length()) {
                    System.out.println("Senha invalida.");
                }
                else {
                    System.out.println("Senha valida.");
                }
                lowercase = 0;
                uppercase = 0;
                digit = 0;
            }
        }

    }
}