import java.util.Scanner;
import java.util.ArrayList;

public class FlaviousJosephus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfCases = scanner.nextInt();
        for(int caseNum = 1; caseNum <= countOfCases; caseNum++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            ArrayList<Integer> list = new ArrayList<>(n);
            for(int i = 1; i <= n; i++)
                list.add(i);

            int indexToRemove = 0;
            while(list.size() != 1) {
                indexToRemove += k - 1;
                if(indexToRemove >= list.size()) 
                    indexToRemove %= list.size();           
                list.remove(indexToRemove);
            }

            System.out.printf("Case %d: %d%n", caseNum, list.get(0));
        }


    }
}