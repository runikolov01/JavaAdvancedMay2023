package Exams.Exam25June2022.Exam18Febr2023;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BlindMansBuff_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int rows = list.get(0);
        int cols = list.get(1);
        char[][] matrix = new char[rows][cols];

        int curRow = 0;
        int curCol = 0;

        for (int ro = 0; ro < rows; ro++) {
            String[] rowArr = scan.nextLine().split("\\s+");
            for (int co = 0; co < cols; co++) {
                char currentSymbol = rowArr[co].charAt(0);
                if (currentSymbol == 'B' || currentSymbol == 'O' || currentSymbol == 'P' || currentSymbol == '-') {
                    matrix[ro][co] = currentSymbol;
                }
                if (currentSymbol == 'B') {
                    curCol = co;
                    curRow = ro;
                }
            }
        }

        int touched = 0;
        int movements = 0;

        String command = "";

        while (!command.equals("Finish")) {
            command = scan.nextLine();
            if (command.equals("up")) {
                curRow -= 1;
                if (curRow < 0) {
                    curRow += 1;
                    continue;
                } else {
                    char currentSymbol = matrix[curRow][curCol];
                    if (currentSymbol == 'O') {
                        curRow += 1;
                        continue;
                    } else if (currentSymbol == 'P') {
                        movements++;
                        touched++;
                        matrix[curRow + 1][curCol] = '-';
                        if (touched == 3) {
                            matrix[curRow][curCol] = '-';
                            break;
                        }
                    } else if (currentSymbol == '-') {
                        movements++;
                        matrix[curRow + 1][curCol] = '-';
                        matrix[curRow][curCol] = '-';
                    }
                }
            } else if (command.equals("down")) {
                curRow += 1;
                if (curRow >= rows) {
                    curRow -= 1;
                    continue;
                } else {
                    char currentSymbol = matrix[curRow][curCol];
                    if (currentSymbol == 'O') {
                        curRow -= 1;
                        continue;
                    } else if (currentSymbol == 'P') {
                        movements++;
                        touched++;
                        matrix[curRow - 1][curCol] = '-';
                        if (touched == 3) {
                            matrix[curRow][curCol] = '-';
                            break;
                        }
                    } else if (currentSymbol == '-') {
                        movements++;
                        matrix[curRow - 1][curCol] = '-';
                        matrix[curRow][curCol] = '-';
                    }
                }
            } else if (command.equals("right")) {
                curCol += 1;
                if (curCol >= cols) {
                    curRow -= 1;
                    continue;
                } else {
                    char currentSymbol = matrix[curRow][curCol];
                    if (currentSymbol == 'O') {
                        curCol -= 1;
                        continue;
                    } else if (currentSymbol == 'P') {
                        movements++;
                        touched++;
                        matrix[curRow][curCol - 1] = '-';
                        if (touched == 3) {
                            matrix[curRow][curCol] = '-';
                            break;
                        }

                    } else if (currentSymbol == '-') {
                        movements++;
                        matrix[curRow][curCol - 1] = '-';
                        matrix[curRow][curCol] = '-';
                    }
                }
            } else if (command.equals("left")) {
                curCol -= 1;
                if (curCol < 0) {
                    curCol += 1;
                    continue;
                } else {
                    char currentSymbol = matrix[curRow][curCol];
                    if (currentSymbol == 'O') {
                        curCol += 1;
                        continue;
                    } else if (currentSymbol == 'P') {
                        movements++;
                        touched++;
                        matrix[curRow][curCol + 1] = '-';
                        if (touched == 3) {
                            matrix[curRow][curCol] = '-';
                            break;
                        }
                    } else if (currentSymbol == '-') {
                        movements++;
                        matrix[curRow][curCol + 1] = '-';
                        matrix[curRow][curCol] = '-';
                    }
                }
            }
        }

        System.out.println("Game over!");
        System.out.println("Touched opponents: " + touched + " Moves made: " + movements);
    }
}
