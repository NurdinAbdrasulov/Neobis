import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int times = scan.nextInt();
        for (int i = 0; i < times; i++) {
            int check = scan.nextInt();
            int amount = 0;
            for (int j = 1; j <= check / 2; j++){
                if (check % j == 0) {
                    amount += j;
                }
            }
            if (check == amount) {
                System.out.print(check + " eh perfeito\n");
            } else {
                System.out.print(check + " nao eh perfeito\n");
            }
        }
    }
}