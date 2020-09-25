import java.util.*;
public class Main {

    static final char max = 90;
    static final char min = 65;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < times; i++) {
            String text = scan.nextLine();
            int key = scan.nextInt();
            decrypt(text.toCharArray(), key);
            scan.nextLine();
        }
    }
   private static void decrypt(char[] x, int key) {
        for (char ch : x) {
            if (ch >= min && ch <= max) {
                if(ch - key < min) {
                    System.out.print((char)(max - (min + key - ch) + 1));
                } else {
                    System.out.print((char)(ch - key));
                }
            }
        }
       System.out.print("\n");
    }
}