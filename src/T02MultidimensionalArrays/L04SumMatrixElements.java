package T02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputArr = scan.nextLine().split(", ");
        int rows = Integer.parseInt(inputArr[0]);
        int colums = Integer.parseInt(inputArr[1]);

        int[][] matrix = new int[rows][colums];
        int sum = 0;

        //int[] rowOfMatrix = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int r = 0; r < rows; r++) {
            int counter = 0;
            String[] arr = scan.nextLine().split(", ");
            for (int c = 0; c < colums; c++) {
                int currentElement = Integer.parseInt(arr[counter]);
                matrix[r][c] = currentElement;
                sum += currentElement;
                counter++;
            }
        }

        System.out.println(rows);
        System.out.println(colums);
        System.out.println(sum);
    }
}
