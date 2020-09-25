import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String one = scan.nextLine();
            String two = scan.nextLine();

            int out = 0;
            for (int i = 0; i < Math.max(one.length() , two.length()); i++) {
                for (int j = 0; j < Math.min(one.length() , two.length()) - i; j++) {
                    if (two.contains(one.substring(j , j + i))) {
                        if (out < i) out = i;
                    }
                }
            }
            System.out.println(out);
        }
    }
}
