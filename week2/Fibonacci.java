import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();                               
        for(int i = 0;  i < n; i++) {
            int val = scanner.nextInt();
            System.out.printf("Fib(%d) = %d%n", val, fun(val));
	}
                                 

    }

    private static long fun(int index){
        if (index == 0)
            return 0;
        else{
            long first = 0;
            long second = 1;
            for (int i = 2; i <= index; i++) {
                long next = first + second;
                first = second;
                second = next;
            }
            return second;
        }
    }
}
