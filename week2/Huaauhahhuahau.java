import java.util.Scanner;

public class Huaauhahhuahau{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
	
	String line = scanner.nextLine();
	String lineVowels = "";
	for(int i = 0; i < line.length(); i++)
	    if(line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u')
	        lineVowels += line.charAt(i);

	boolean isFunniest = true;
	for(int i = 0, j = lineVowels.length() - 1; i < lineVowels.length() / 2; i++, j--)
	    if(lineVowels.charAt(i) != lineVowels.charAt(j)) {
	        isFunniest = false;
	        break;
            }
	System.out.println(isFunniest ? "S" :  "N");        
	                                             


    }
}