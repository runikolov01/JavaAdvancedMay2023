package T02MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = rows;

        String[][] matrix = new String[rows][cols];

        // Пълним масива:
        for (int r = 0; r < rows; r++) {
            String[] arrInput = scan.nextLine().split("\\s+");
            int counter = 0;
            for (int c = 0; c < cols; c++) {
                String curEl = arrInput[counter];
                matrix[r][c] = curEl;
                counter++;
            }
        }

        // Търсим първия диагонал:
        // 00
        // 11
        // 22

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == c) {
                    String curEl = matrix[r][c];
                    System.out.printf(curEl + " ");
                }
            }
        }
        System.out.println();

        // Принтиране на втория диагонал
        // 02 row col-row
        //11 row col-row
        //20 row col-row

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (c == cols - r - 1) {
                    String curEl = matrix[r][c];
                    stack.push(curEl);
                    //  System.out.printf(curEl + " ");
                }
            }
        }
        if (!stack.isEmpty()) {
            for (String el : stack) {
                System.out.printf(el + " ");
            }
        }
    }
}
