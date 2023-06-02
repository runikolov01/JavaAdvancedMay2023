package T02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int rows = n;
        int cols = n;


        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            int[] inpArr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int c = 0; c < cols; c++) {
                int curEl = inpArr[c];
                matrix[r][c] = curEl;
            }
        }
        // Primary

        int primarySum = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == c) {
                    int curEl = matrix[r][c];
                    primarySum += curEl;
                }
            }
        }
        //Secondary
        int secondarySum = 0;
        int counter = cols - 1;
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {
                if (c == counter) {
                    int curEl = matrix[r][c];
                    secondarySum += curEl;
                    counter -= 1;
                }
            }
        }

        // System.out.println(primarySum);
        // System.out.println(secondarySum);
        int abs = Math.abs(primarySum - secondarySum);
        System.out.println(abs);
    }
}
