package T02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L02PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inpArr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rowsCount = inpArr[0];
        int colsCount = inpArr[1];

        int[][] matrix = new int[rowsCount][colsCount];

        for (int r = 0; r < rowsCount; r++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int counter = 0;
            for (int c = 0; c < colsCount; c++) {
                int currentElement = arr[counter];
                matrix[r][c] = currentElement;
                counter++;
            }
        }

        int searchedNumber = Integer.parseInt(scan.nextLine());

        boolean isThere = false;
        for (int k = 0; k < rowsCount; k++) {
            for (int j = 0; j < colsCount; j++) {
                int curEl = matrix[k][j];
                if (curEl == searchedNumber) {
                    System.out.printf(k + " " + j + "%n");
                    isThere = true;
                }
            }
        }
        if (!isThere) {
            System.out.println("not found");
        }

    }
}
