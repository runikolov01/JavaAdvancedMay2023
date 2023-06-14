package Exams.Exam14April2021;

import java.util.Scanner;

public class CookingJourney_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = rows;
        char[][] matrix = new char[rows][cols];
        int currentRow = 0;
        int currentCol = 0;
        int firstPillarRow = 0;
        int firstPillarCol = 0;
        int secondPillarRow = 0;
        int secondPillarCol = 0;
        int counterPillar = 0;

        for (int r = 0; r < rows; r++) {
            String[] input = scan.nextLine().split("");
            for (int c = 0; c < cols; c++) {
                char currentSymbol = input[c].charAt(0);
                matrix[r][c] = currentSymbol;
                if (currentSymbol == 'S') {
                    currentRow = r;
                    currentCol = c;
                } else if (currentSymbol == 'P') {
                    counterPillar += 1;
                    if (counterPillar % 2 == 1) {
                        firstPillarRow = r;
                        firstPillarCol = c;
                    } else {
                        secondPillarRow = r;
                        secondPillarCol = c;
                    }
                }
            }

        }

        boolean outOfMatrix = false;
        boolean collectedMoney = false;
        int sum = 0;

        while (!outOfMatrix && !collectedMoney) {
            String command = scan.nextLine();

            if (command.equals("up")) {
                matrix[currentRow][currentCol] = '-';
                if (currentRow - 1 >= 0) {
                    currentRow -= 1;
                } else {
                    outOfMatrix = true;
                    break;
                }
            } else if (command.equals("down")) {
                matrix[currentRow][currentCol] = '-';
                if (currentRow + 1 < rows) {
                    currentRow += 1;
                } else {
                    outOfMatrix = true;
                    break;
                }
            } else if (command.equals("left")) {
                matrix[currentRow][currentCol] = '-';
                if (currentCol - 1 >= 0) {
                    currentCol -= 1;
                } else {
                    outOfMatrix = true;
                    break;
                }

            } else if (command.equals("right")) {
                matrix[currentRow][currentCol] = '-';
                if (currentCol + 1 < cols) {
                    currentCol += 1;
                } else {
                    outOfMatrix = true;
                    break;
                }
            }

            char currentSymbol = matrix[currentRow][currentCol];
            if (currentSymbol >= 48 && currentSymbol <= 59) {
                String numChar = currentSymbol + "";
                int number = Integer.parseInt(numChar);
                sum += number;
            } else if (currentSymbol == 'P') {
                matrix[currentRow][currentCol] = '-';
                currentCol = secondPillarCol;
                currentRow = secondPillarRow;
                matrix[currentRow][currentCol] = '-';
            }
            if (sum >= 50) {
                collectedMoney = true;
                break;
            }
        }

        if (outOfMatrix) {
            matrix[currentRow][currentCol] = '-';
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            matrix[currentRow][currentCol] = 'S';
        }
        if (collectedMoney) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + sum);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.printf("%c", matrix[r][c]);
            }
            System.out.println();
        }
    }
}
