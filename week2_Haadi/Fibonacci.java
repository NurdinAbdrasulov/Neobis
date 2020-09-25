import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long[] fib = new long[61];
        int number = scan.nextInt();
        fibonacci(fib);

        for (; number > 0; number--) {
            int index = scan.nextInt();
            System.out.printf("Fib(%d) = %d%n", index , fib[index] );
        }
    }
    static void fibonacci(long[] fib) {
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }
}