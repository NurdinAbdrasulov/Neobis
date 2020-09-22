
import java.util.Scanner;

public class PasswordsValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	while( scanner.hasNextLine()){
	    String input = scanner.nextLine();
	    System.out.println( isValided(input)? "Senha valida." : "Senha invalida."); 	    
	}	 
    }

    private static boolean isValided(String input){
	boolean isContainedUppercase = false;  
	boolean isContainedLowercase = false; 
	boolean isContainedNumber = false;
	
	if(!(input.length() >= 6 && input.length() <= 32))
	    return false;
        for(int i = 0; i < input.length(); i ++){
	    if( Character.isDigit(input.charAt(i)) ){
		if(!isContainedNumber)
		    isContainedNumber = true;
		    continue;
	    } else if( input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
	        if(!isContainedLowercase)
		    isContainedLowercase = true;
		    continue;
	    } else if( input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
	        if(!isContainedUppercase)
		    isContainedUppercase = true;
		    continue;
	    } else
		return false;        
	}

	if(isContainedUppercase && isContainedLowercase && isContainedNumber)
	    return true;
	else 
	    return false;
    }
}