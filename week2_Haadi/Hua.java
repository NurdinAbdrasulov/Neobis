import java.util.Scanner;

public class hua {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String in = ler.nextLine();
        char[] arr = in.toCharArray();
        char[] y = new char[arr.length];
        char[] x = new char[arr.length];
        int j = y.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                y[j] = arr[i];
                j--;
            }
        }
        j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                x[j] = arr[i];
                j++;
            }
        }
        String y2 = new String(y);
        String x2 = new String(x);
        x2 = x2.trim();
        y2 = y2.trim();

        if (x2.equals(y2)) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }
}
