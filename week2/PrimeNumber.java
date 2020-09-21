import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

	int countOfCases = scanner.nextInt();
	while( countOfCases-- > 0 ){
	    int input = scanner.nextInt();
	    System.out.println(input + (isPrime(input) ? " eh primo" : " nao eh primo")); 

	}
    }

    private static boolean isPrime(int val) {
	int half = val / 2 + 1;
	if( val != 2 )
            for(int i = 2; i < half; i++)
    	        if(val % i == 0)
    	            return false;       
	return true;

    }


}