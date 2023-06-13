package Exams.Exam12April2023;

import java.util.Scanner;

public class TheSquirrel_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int collectedHazelnuts = 0;
        int rows = Integer.parseInt(scan.nextLine());
        int cols = rows;
        char[][] matrix = new char[rows][cols];
        int currentRow = 0;
        int currentCol = 0;

        String[] directionsArr = scan.nextLine().split(", ");

        //PULNENE NA MASIVA
        for (int ro = 0; ro < rows; ro++) {
            String input = scan.nextLine();
            for (int co = 0; co < cols; co++) {
                char currentInput = input.charAt(co);
                if (currentInput == 's' || currentInput == 'h' || currentInput == '*' || currentInput == 't') {
                    matrix[ro][co] = currentInput;
                    if (currentInput == 's') {
                        currentCol = co;
                        currentRow = ro;
                    }
                }
            }
        }
        // int newRow = 0;
        //int newCol = 0;
        boolean outOfTheFild = false;
        boolean trapSteped = false;
        char newSymbol = 'a';

        for (int i = 0; i < directionsArr.length; i++) {
            String currentDirection = directionsArr[i];
            if (currentDirection.equals("left")) {
                currentCol -= 1;
                //currentRow = currentRow;
                if (currentCol < 0) {
                    outOfTheFild = true;
                    break;
                } else {
                    newSymbol = matrix[currentRow][currentCol];
                    if (newSymbol == 't') {
                        trapSteped = true;
                        break;
                    } else if (newSymbol == 'h') {
                        matrix[currentRow][currentCol] = '*';
                        collectedHazelnuts++;
                    }
                    matrix[currentRow][currentCol] = '*';
                }
            } else if (currentDirection.equals("right")) {
                currentCol = currentCol + 1;
                currentRow = currentRow;
                if (currentCol >= cols) {
                    outOfTheFild = true;
                    break;
                } else {
                    newSymbol = matrix[currentRow][currentCol];
                    if (newSymbol == 't') {
                        trapSteped = true;
                        break;
                    } else if (newSymbol == 'h') {
                        matrix[currentRow][currentCol] = '*';
                        collectedHazelnuts++;
                    }
                    matrix[currentRow][currentCol] = '*';
                }
            } else if (currentDirection.equals("up")) {
                //currentCol = currentCol;
                currentRow = currentRow - 1;
                if (currentRow < 0) {
                    outOfTheFild = true;
                    break;
                } else {
                    newSymbol = matrix[currentRow][currentCol];
                    if (newSymbol == 't') {
                        trapSteped = true;
                        break;
                    } else if (newSymbol == 'h') {
                        matrix[currentRow][currentCol] = '*';
                        collectedHazelnuts++;
                    }
                    matrix[currentRow][currentCol] = '*';
                }
            } else if (currentDirection.equals("down")) {
                //currentCol = currentCol;
                currentRow = currentRow + 1;
                if (currentRow >= rows) {
                    outOfTheFild = true;
                    break;
                } else {
                    newSymbol = matrix[currentRow][currentCol];
                    if (newSymbol == 't') {
                        trapSteped = true;
                        break;
                    } else if (newSymbol == 'h') {
                        matrix[currentRow][currentCol] = '*';
                        collectedHazelnuts++;
                    }
                    matrix[currentRow][currentCol] = '*';
                }
            }
        }
        if (outOfTheFild) {
            System.out.println("The squirrel is out of the field.");
        }
        else if (trapSteped) {
            System.out.println("Unfortunately, the squirrel stepped on a trap...");
        }
        else if (collectedHazelnuts < 3) {
            System.out.println("There are more hazelnuts to collect.");
        } else {
            System.out.println("Good job! You have collected all hazelnuts!");
        }

        System.out.println("Hazelnuts collected: " + collectedHazelnuts);

    }


}
