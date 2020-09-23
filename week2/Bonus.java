import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] array = new int[4][4];
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                array[i][j] = scanner.nextInt();
        int move = scanner.nextInt();

        magic(array, move);

        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }

    private static void magic(int[][] array, int move){
        switch (move){
            case 0:
                loop: for (int i = 0; i < array.length; i++)
                    for (int j = 0; j < array[i].length - 1; j++) {
                        if (array[i][j] == 0)
                            continue;
                        int nextJ = j + 1;
                        while (array[i][nextJ] == 0) {
                            nextJ++;
                            if (nextJ > array[i].length - 1)
                                continue loop;
                        }
                        if (array[i][j] == array[i][nextJ]) {
                            array[i][j] += array[i][nextJ];
                            array[i][nextJ] = 0;
                        }
                    }

                loop2:   for(int i = 0; i < array.length; i++)
                    for(int j = 0; j < array[i].length -1; j++)
                        if(array[i][j] == 0){
                            int nextJ = j + 1;
                            while(array[i][nextJ] == 0) {
                                nextJ++;
                                if(nextJ > array[i].length -1)
                                    continue loop2;
                            }
                            array[i][j] = array[i][nextJ];
                            array[i][nextJ] = 0;
                        }
                break;
            case 1:
                loop: for(int j = 0; j < array.length; j++)
                    for(int i = 0; i < array.length - 1 ; i++){
                        if(array[i][j] == 0)
                            continue;
                        int nextI = i+1;
                        while(array[nextI][j] == 0){
                            nextI++;
                            if(nextI > array[i].length - 1)
                                continue loop;
                        }
                        if(array[i][j] == array[nextI][j]){
                            array[i][j] += array[nextI][j];
                            array[nextI][j] = 0; //continue is that ++j
                        }
                    }

                loop2:   for(int j = 0; j < array.length; j++)
                    for(int i = 0; i < array[i].length -1; i++)
                        if(array[i][j] == 0){
                            int nextI = i + 1;
                            while(array[nextI][j] == 0) {
                                nextI++;
                                if(nextI > array[i].length -1)
                                    continue loop2;
                            }
                            array[i][j] = array[nextI][j];
                            array[nextI][j] = 0;
                        }
                break;
            case 2:
                loop: for (int i = array.length - 1; i >= 0; i--)
                    for (int j = array.length - 1; j > 0; j--) {
                        if (array[i][j] == 0)
                            continue;
                        int nextJ = j - 1;
                        while (array[i][nextJ] == 0) {
                            nextJ--;
                            if (nextJ < 0 )
                                continue loop;
                        }
                        if (array[i][j] == array[i][nextJ]) {
                            array[i][j] += array[i][nextJ];
                            array[i][nextJ] = 0;
                        }
                    }

                loop2: for(int i = array.length -1; i >=0 ; i--)
                    for(int j = array.length - 1; j > 0 ; j--)
                        if(array[i][j] == 0){
                            int nextJ = j - 1;
                            while(array[i][nextJ] == 0) {
                                nextJ--;
                                if(nextJ < 0)
                                    continue loop2;
                            }
                            array[i][j] = array[i][nextJ];
                            array[i][nextJ] = 0;
                        }
                break;
            case 3:
                loop: for(int j = array.length -1; j >= 0; j--)
                    for(int i = array.length - 1; i > 0  ; i--){
                        if(array[i][j] == 0)
                            continue;
                        int nextI = i-1;
                        while(array[nextI][j] == 0){
                            nextI--;
                            if(nextI < 0)
                                continue loop;
                        }
                        if(array[i][j] == array[nextI][j]){
                            array[i][j] += array[nextI][j];
                            array[nextI][j] = 0; //continue is that ++j
                        }
                    }

                loop2: for(int j = array.length -1; j >=0 ; j--)
                    for(int i = array.length - 1; i > 0 ; i--)
                        if(array[i][j] == 0){
                            int nextI = i - 1;
                            while(array[nextI][j] == 0) {
                                nextI--;
                                if(nextI < 0)
                                    continue loop2;
                            }
                            array[i][j] = array[nextI][j];
                            array[nextI][j] = 0;
                        }
                break;
        }
    }

}