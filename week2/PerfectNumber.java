import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	int countOfCases = scanner.nextInt();
	for( int i = 0; i < countOfCases; i++){
	    int input = scanner.nextInt();
	    System.out.println( input + (isPerfect(input)? " eh perfeito": " nao eh perfeito"));
	}                                                                                   
    }

    private static boolean isPerfect(int input){
        int sum = 0;
	    for(int i = 1; i < input; i ++){
		sum += i;
	    	if(sum == input)
		    return true;
	    }
	return false;
    }
}