package Exams.Exam16Dec2020;

import java.util.Scanner;

public class Selling_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = rows;
        int currentRow = 0;
        int currentCol = 0;
        int rowFirstPillar = 0;
        int colFirstPillar = 0;
        int rowSecondPillar = 0;
        int colSecondPillar = 0;

        int counterPillar = 0;

        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            String[] inputArr = scan.nextLine().split("");
            for (int c = 0; c < cols; c++) {
                char currentSymbol = inputArr[c].charAt(0);
                if (currentSymbol == 'S') {
                    currentCol = c;
                    currentRow = r;
                } else if (currentSymbol == 'O' && colFirstPillar == 0) {
                    rowFirstPillar = r;
                    colFirstPillar = c;
                    counterPillar++;
                } else if (currentSymbol == 'O' && counterPillar == 1) {
                    rowSecondPillar = r;
                    colSecondPillar = c;
                    counterPillar++;
                }
                matrix[r][c] = currentSymbol;

            }
        }

        boolean outOfMatrix = false;
        int sumCounter = 0;
        boolean collectedMoney = false;

        while (!outOfMatrix && !collectedMoney) {
            String command = scan.nextLine();
            if (command.equals("up")) {
                matrix[currentRow][currentCol] = '-';
                if (currentRow - 1 < 0) {
                    outOfMatrix = true;
                    break;
                } else {
                    currentRow--;

                }
            } else if (command.equals("down")) {
                matrix[currentRow][currentCol] = '-';

                if (currentRow + 1 >= rows) {
                    outOfMatrix = true;
                    break;
                } else {
                    currentRow++;

                }
            } else if (command.equals("left")) {
                matrix[currentRow][currentCol] = '-';

                if (currentCol - 1 < 0) {
                    outOfMatrix = true;
                    break;
                } else {
                    currentCol--;
                }

            } else if (command.equals("right")) {
                matrix[currentRow][currentCol] = '-';
                if (currentCol + 1 >= cols) {
                    outOfMatrix = true;
                    break;
                } else {
                    currentCol++;
                }
            }
            char currentSymbol = matrix[currentRow][currentCol];

            if (currentSymbol >= 48 && currentSymbol <= 59) {
                String numChar = currentSymbol + "";
                int number = Integer.parseInt(numChar);
                sumCounter += number;
            } else if (currentSymbol == 'O') {
                if (currentRow == rowFirstPillar && currentCol == colFirstPillar) {
                    matrix[currentRow][currentCol] = '-';
                    currentRow = rowSecondPillar;
                    currentCol = colSecondPillar;
                    matrix[currentRow][currentCol] = '-';
                } else {
                    matrix[currentRow][currentCol] = '-';
                    currentRow = rowFirstPillar;
                    currentCol = colFirstPillar;
                    matrix[currentRow][currentCol] = '-';
                }
            }
            if (sumCounter >= 50) {
                collectedMoney = true;
                break;
            }
        }

        if (outOfMatrix) {
            matrix[currentRow][currentCol] = '-';
            System.out.println("Bad news, you are out of the bakery.");
        } else if (collectedMoney) {
            matrix[currentRow][currentCol] = 'S';
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", sumCounter);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.printf("%c", matrix[r][c]);
            }
            System.out.println();
        }
    }
}
