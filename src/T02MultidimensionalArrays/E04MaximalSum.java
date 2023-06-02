package T02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E04MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        int[][] matrix = new int[rows][cols];

        if (rows >= 3 && cols >= 3) {
            fillMatrix(matrix, rows, cols, scan);

        }
    }

    private static void fillMatrix(int[][] matrix, int rows, int cols, Scanner scan) {
        int counter = 0;
        for (int r = 0; r < rows; r++) {
            int[] inpArr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int c = 0; c < cols; c++) {
                int curEl = inpArr[counter];
                matrix[r][c] = curEl;
                counter++;
            }
        }
    }
}
