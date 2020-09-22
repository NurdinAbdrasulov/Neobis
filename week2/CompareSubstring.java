import java.util.Scanner;

public class CompareSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();

            if (line1.length() > line2.length()) {
                String tmp = line2;
                line2 = line1;
                line1 = tmp;
            }

            int result = 0;
            
       loop:for (int len = line1.length(); len > 0; len--) {//кол-во сравниваемых символов
                for (int line1Times = len, toffset = 0; line1Times++ <= line1.length(); toffset++) {// toffset позиция для line1
                    for (int oofset = 0; oofset <= line2.length() - len; oofset++) {// offset позиция для line2
                        if (line1.regionMatches(toffset, line2, oofset, len)) {
                            result = len;
                            break loop;
                        }
                    }
                }
            }
            System.out.println(result);
        }

    }
}