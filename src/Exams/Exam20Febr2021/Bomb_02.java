package Exams.Exam20Febr2021;

import java.util.Scanner;

public class Bomb_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = rows;
        char[][] matrix = new char[rows][cols];
        String[] commandsArr = scan.nextLine().split(",");
        int currentRow = 0;
        int currentCol = 0;
        int bombCounter = 0;
        int addedBomb = 0;

        for (int r = 0; r < rows; r++) {
            String[] inputArr = scan.nextLine().split("\\s+");
            for (int c = 0; c < cols; c++) {

                char currentSymbol = inputArr[c].charAt(0);

                matrix[r][c] = currentSymbol;

                if (currentSymbol == 's') {
                    currentRow = r;
                    currentCol = c;
                } else if (currentSymbol == 'B') {
                    addedBomb++;
                }

            }
        }
        boolean outOfMatrix = false;

        for (int i = 0; i < commandsArr.length; i++) {
            if (outOfMatrix || bombCounter == addedBomb) {
                break;
            } else {
                String currentCommand = commandsArr[i];
                if (currentCommand.equals("up")) {
                    if (currentRow - 1 >= 0) {
                        matrix[currentRow][currentCol] = '+';
                        currentRow -= 1;
                    }

                } else if (currentCommand.equals("down")) {
                    if (currentRow + 1 < rows) {
                        matrix[currentRow][currentCol] = '+';
                        currentRow += 1;
                    }
                } else if (currentCommand.equals("left")) {
                    if (currentCol - 1 >= 0) {
                        matrix[currentRow][currentCol] = '+';
                        currentCol -= 1;
                    }
                } else if (currentCommand.equals("right")) {
                    if (currentCol + 1 < cols) {
                        matrix[currentRow][currentCol] = '+';
                        currentCol += 1;
                    }
                }
                char currentSymbol = matrix[currentRow][currentCol];
                if (currentSymbol == 'B') {
                    bombCounter++;
                    matrix[currentRow][currentCol] = 's';
                    System.out.println("You found a bomb!");
                } else if (currentSymbol == 'e') {
                    matrix[currentRow][currentCol] = 's';
                    outOfMatrix = true;
                    break;
                } else {
                    matrix[currentRow][currentCol] = 's';
                }
            }
        }
        int leftBomb = addedBomb - bombCounter;

        if (bombCounter == addedBomb) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (outOfMatrix) {
            System.out.println("END! " + leftBomb + " bombs left on the field");
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", leftBomb, currentRow, currentCol);
        }
    }
}
