import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grenais {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();

        int interScore = 0;
        int gremioScore = 0;
        int empates = 0;
        String winner = "Não houve vencedor";

        do{
            int[] array = new int[2];
            array[0] = scanner.nextInt();
            array[1] = scanner.nextInt();
            list.add(array);
            System.out.println("Novo grenal (1-sim 2-nao)");
            if(array[0] > array[1])
                interScore++;
            else if(array[0] < array[1])
                gremioScore++;
            else
                empates++;

        }while (scanner.nextInt() != 2);

        if(interScore > gremioScore)
            winner = "Inter venceu mais";
        else if(interScore < gremioScore)
            winner = "Gremio venceu mais";


        System.out.println(list.size() + " grenais\n" +
                "Inter:" + interScore + "\n" +
                "Gremio:" + gremioScore + "\n" +
                "Empates:" + empates + "\n" +
                 winner );
    }
}
