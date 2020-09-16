import java.util.Scanner; 

public class GameTime{
   public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	String input = scanner.nextLine();
	String[] val = input.split(" ");

	int startHour = Integer.parseInt(val[0]);
	int startMinute = Integer.parseInt(val[1]);
	int endHour = Integer.parseInt(val[2]);
	int endMinute = Integer.parseInt(val[3]);

	if(endMinute < startMinute){
	    endHour--;
	    endMinute += 60;
	}	
	int resultMinute = endMinute - startMinute;
	
	if(endHour < startHour || (endHour == startHour && resultMinute < 1))
	    endHour += 24;                     
	int resultHour = endHour - startHour;                                                 

	System.out.println("O JOGO DUROU " + resultHour + " HORA(S) E " + resultMinute + " MINUTO(S)");    
    }
}