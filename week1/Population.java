import java.util.Scanner;

public class Population{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int numberOfTests = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numberOfTests; i++){
            String[] line = scanner.nextLine().split(" ");
            int pA = Integer.parseInt(line[0]);
            int pB = Integer.parseInt(line[1]);
            double g1 = Double.parseDouble(line[2]);
            double g2 = Double.parseDouble(line[3]);

            int count = 0;
            while(pA <= pB){
                pA = (int) (pA + pA * (g1 / 100));
                pB = (int) (pB + pB * (g2 / 100));
                count++;
                if(count > 100)
                    break;
            }

            System.out.println((count <= 100) ? count + " anos." : "Mais de 1 seculo.");

        }
    }
}