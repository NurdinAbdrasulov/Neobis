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
                        int nextJ = j + 1;
                        if(!moveToLeft(array, i, j) || !moveToLeft(array, i, nextJ))
                            continue loop;

                        if (array[i][j] == array[i][nextJ]) {
                            array[i][j] += array[i][nextJ];
                            array[i][nextJ] = 0;
                        }
                    }
                break;
            case 1:
                loop: for(int j = 0; j < array.length; j++)
                    for(int i = 0; i < array.length - 1 ; i++){
                        int nextI = i+1;
                        if(!moveToUp(array, i, j) || !moveToUp(array, nextI, j))
                            continue loop;

                        if(array[i][j] == array[nextI][j]){
                            array[i][j] += array[nextI][j];
                            array[nextI][j] = 0;
                        }
                    }
                break;
            case 2:
                loop: for (int i = array.length - 1; i >= 0; i--)
                    for (int j = array.length - 1; j > 0; j--) {
                        int nextJ = j - 1;
                        if (!moveToRight(array, i, j) || !moveToRight(array, i, nextJ))
                            continue;

                        if (array[i][j] == array[i][nextJ]) {
                            array[i][j] += array[i][nextJ];
                            array[i][nextJ] = 0;
                        }
                    }
                break;
            case 3:
                loop: for(int j = array.length -1; j >= 0; j--)
                    for(int i = array.length - 1; i > 0  ; i--){
                        int nextI = i-1;
                        if (!moveToDown(array, i, j) || !moveToDown(array, nextI, j))
                            continue;

                        if(array[i][j] == array[nextI][j]){
                            array[i][j] += array[nextI][j];
                            array[nextI][j] = 0;
                        }
                    }
                break;
        }
    }

    private static boolean moveToLeft(int[][] array, int i, int j){
        int count = 0;
        while (array[i][j] == 0 && count++ < array[i].length){
            for(int a = j; a < array[i].length - 1; a++)
                array[i][a] = array[i][a + 1];
            array[i][array[i].length - 1] = 0;
        }
        return array[i][j] != 0;
    }

    private static boolean moveToUp(int[][] array, int i, int j){
        int count = 0;
        while (array[i][j] == 0 && count++ < array.length){
            for(int a = i; a < array.length - 1; a++)
                array[a][j] = array[a + 1][j];
            array[array.length - 1][j] = 0;
        }
        return array[i][j] != 0;
    }

    private static boolean moveToRight(int[][] array, int i, int j){
        int count = array[i].length;
        while (array[i][j] == 0 && count-- > 0){
            for(int a = j; a > 0; a--)
                array[i][a] = array[i][a - 1];
            array[i][0] = 0;
        }
        return array[i][j] != 0;
    }

    private static boolean moveToDown(int[][] array, int i, int j){
        int count = array.length;
        while (array[i][j] == 0 && count-- > 0){
            for(int a = i; a > 0; a--)
                array[a][j] = array[a-1][j];
            array[0][j] = 0;
        }
        return array[i][j] != 0;
    }

}