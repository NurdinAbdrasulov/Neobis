import java.util.Scanner;

public class Column {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);

        double[][] matrix = new double[12][12];

        int column =  sc.nextInt();
        sc.nextLine();
        String operation = sc.nextLine();
        double result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = sc.nextDouble();
                if(i == j) {
                    result += matrix[i][j];
                }
            }
        }
        if (operation.equals("M")) {
            return /= 12;
        }
        System.out.printf("%.1f%n" , result);
    }
}