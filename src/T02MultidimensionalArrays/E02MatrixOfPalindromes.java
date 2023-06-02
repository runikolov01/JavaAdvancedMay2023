package T02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();

        String[][] matrix = new String[rows][cols];
        char startLetter = 'a';
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String polindrome = "" + startLetter + (char) (startLetter + c) + startLetter;
                matrix[r][c] = polindrome;
            }
            startLetter = (char) (startLetter + 1);
        }
        printMatrix(matrix, rows, cols);
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}
