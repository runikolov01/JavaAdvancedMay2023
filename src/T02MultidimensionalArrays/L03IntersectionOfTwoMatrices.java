package T02MultidimensionalArrays;

import java.util.Scanner;

public class L03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            String[] inpArr = scan.nextLine().split("\\s+");
            int counter = 0;
            for (int c = 0; c < cols; c++) {
                char currentEl = inpArr[counter].charAt(0);
                firstMatrix[r][c] = currentEl;
                counter++;
            }
        }

        char[][] secondMatrix = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            String[] inpArr = scan.nextLine().split("\\s+");
            int counter = 0;
            for (int c = 0; c < cols; c++) {
                char currentEl = inpArr[counter].charAt(0);
                secondMatrix[r][c] = currentEl;
                counter++;
            }
        }

        for (int r = 0; r < rows; r++) {
            int counter = 0;
            for (int c = 0; c < cols; c++) {
                char fCurEl = firstMatrix[r][c];
                char sCurEl = secondMatrix[r][c];
                if (fCurEl != sCurEl) {
                    firstMatrix[r][c] = '*';
                    secondMatrix[r][c] = '*';
                }
                counter++;
            }
        }

        for (int r = 0; r < rows; r++) {
            int counter = 0;
            for (int c = 0; c < cols; c++) {
                char curEl = firstMatrix[r][c];
                System.out.printf(String.valueOf(curEl) + " ");
                counter++;
            }
            System.out.println();
        }
    }
}
