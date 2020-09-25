import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int in = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < in; i++) {
            String initial = scan.nextLine();
            String[] mid = initial.split(" ");
            String one = mid[0];
            String two = mid[1];

            int len = Math.min(one.length(), two.length());

            for (int z = 0; z <  len; z++) {
                System.out.print(one.charAt(z));
                System.out.print(two.charAt(z));
            }
            String out = (one.length() > two.length()) ? one : two;
            System.out.print(out.substring(len));
            System.out.println();
        }
    }
}
