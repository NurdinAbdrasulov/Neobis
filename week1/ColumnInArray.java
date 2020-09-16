import java.util.Scanner;

public class ColumnInArray{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

	int columnNum = scanner.nextInt();
	char operation = scanner.next().charAt(0);

	double[][] array = new double[12][12];
	double result = 0;         
	for(int i = 0; i < 12; i ++)
	    for(int j = 0; j < 12; j ++){
		array[i][j] = scanner.nextDouble();
	        if(j == columnNum) 
		   result += array[i][j];	
	    }
	                 

	if(operation == 'S')
	    System.out.printf("%.1f\n", result);
        else if(operation == 'M')
	    System.out.printf("%.1f\n", result / 12); 

    }         
}