package T02MultidimensionalArrays;

import java.util.Scanner;

public class E01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inpArr = scan.nextLine().split(", ");
        int num = Integer.parseInt(inpArr[0]);
        String patttern = inpArr[1];
        int finalNum = num * num;
        int rows = num;
        int cols = num;
        int counter = 1;
        int[][] matrix = new int[rows][cols];

        if (patttern.equals("A")) {
            fillMatrixPatternA(matrix);
        } else if (patttern.equals("B")) {
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);


    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                int currentElement = matrix[r][c];
                System.out.printf(currentElement + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }
}
