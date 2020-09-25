
import java.util.Scanner;


public class Main {
    // 0 left, 1 up etc...
    private static int[][] matrix = new int[4][4];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }
            int dir = scan.nextInt();
            for (int i = 0; i < dir; i++) {
                inverse();
            }
            move();
            if (dir != 0) {
                for (int i = 0; i < (4 - dir); i++) {
                    inverse();
                }
            }
            view();
        }
    }

    private static void inverse() {
        int[][] newMatrix = new int[matrix.length][matrix.length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                newMatrix[matrix.length - 1 - j][matrix.length - 1 - i] = matrix[matrix.length - 1 - i][j];
            }
        }
        matrix = newMatrix;
    }

    // Here comes shitty magic )))
    private static void move() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // ADDING
                if (matrix[i][j] != 0) {
                    for (int z = j + 1; z < matrix[i].length; z++) {
                        if (matrix[i][z] != 0 && matrix[i][j] != matrix[i][z]) {
                            break;
                        } else if (matrix[i][j] != 0 && matrix[i][j] == matrix[i][z]) {
                            matrix[i][j] += matrix[i][z];
                            matrix[i][z] = 0;
                            break;
                        }
                    }
                }
            }
            for (int a = 0; a < matrix[i].length; a++) {
                // SHIFTING
                if (matrix[i][a] == 0) {
                    for (int x = a + 1; x < matrix[i].length; x++) {
                        if (matrix[i][x] != 0) {
                            matrix[i][a] = matrix[i][x];
                            matrix[i][x] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void view () {
        for (int[] out : matrix) {
            for (int i = 1; i <= out.length; i++) {
                System.out.print(out[i - 1] + " ");
                if (i % 4 == 0) System.out.println();
            }
        }
    }
}