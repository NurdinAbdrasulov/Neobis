import java.util.Scanner;

public class Combiner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	int counOfCases = Integer.parseInt(scanner.nextLine());
	while(counOfCases-- > 0){
	    String[] line = scanner.nextLine().split(" ");
	    String val1 = line[0];
	    String val2 = line[1];

	    String result = "";
	    String longestLine = (val1.length() > val2.length()) ? val1 : val2;
	    int shortestLength = (val1.length() < val2.length()) ? val1.length() : val2.length();
	    for(int i = 0 ; i < shortestLength; i ++)
		result = result + val1.charAt(i) + val2.charAt(i);
	    result += longestLine.substring(shortestLength);
	    System.out.println(result);     
	}
    } 
}