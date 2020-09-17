import java.util.Scanner;

public class WeightedAverages{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
	for(int i = 0; i < n; i ++){
	    String[] val = scanner.nextLine().split(" ");
	    float result = Float.parseFloat(val[0]) * 0.2f;
	    result += Float.parseFloat(val[1]) * 0.3;
	    result += Float.parseFloat(val[2]) * 0.5;

	    System.out.printf("%.1f\n", result);     	    

	}  

    }
}