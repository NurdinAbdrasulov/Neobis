import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = scan.nextInt();

        for (int i = 0; i < times; i++) {
            int check = scan.nextInt();
            int compare = 0;
            for (int j = 1; j < check; j++) {
                if (check % j == 0) {
                    compare++;
                }
            }
            if (compare == 2){
                System.out.println("$check eh primo");
            }
            else {
                System.out.println("$check nao eh primo");
            }
        }

    }
