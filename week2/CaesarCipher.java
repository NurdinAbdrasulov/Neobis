import java.util.Scanner;

public class CaesarCipher {
    public static void main( String[] args ) {
	Scanner scanner = new Scanner(System.in);

	int countOfCases = Integer.parseInt( scanner.nextLine() );
	while( countOfCases-- > 0 ){
	    String message = scanner.nextLine();
  	    byte rightShift = Byte.parseByte(scanner.nextLine());
	    String output = "";                           

	    for(int i = 0; i < message.length(); i++)
		if('A' <= message.charAt(i) - rightShift)
	            output += (char) (message.charAt(i) - rightShift);
		else
	            output += (char) (('Z' - ('A' -  (message.charAt(i) - rightShift))) + 1);        		      	           
	    System.out.println(output);

	}

    }




}