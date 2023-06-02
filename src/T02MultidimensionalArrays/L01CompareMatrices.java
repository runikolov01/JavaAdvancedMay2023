package T02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L01CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] firstInputArr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstRows = firstInputArr[0];
        int firstCols = firstInputArr[1];
        int[][] firstMatrix = new int[firstRows][firstCols];


        boolean isEqual = true;

        //ВЪВЕЖДАМЕ ЕЛЕМЕНТИТЕ В МАТРИЦАТА
        for (int fr = 0; fr < firstRows; fr++) {
            int[] firstInputArray = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int counter = 0;
            for (int fc = 0; fc < firstCols; fc++) {
                int currentElement = firstInputArray[counter];
                firstMatrix[fr][fc] = currentElement;
                counter++;
            }
        }

        int[] secondInputArr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int secondRows = secondInputArr[0];
        int secondCols = secondInputArr[1];
        int[][] secondMatrix = new int[secondRows][secondCols];

        for (int sr = 0; sr < secondRows; sr++) {
            int[] secondInputArray = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int counter = 0;
            for (int sc = 0; sc < secondCols; sc++) {
                int currentElement = secondInputArray[counter];
                secondMatrix[sr][sc] = currentElement;
                counter++;
            }
        }

        // ЧЕТЕМ ЕЛЕМЕНТИТЕ ОТ МАТРИЦИТЕ И ПРОВЕРЯВАМЕ ДАЛИ СА РАВНИ
        if (firstRows == secondRows && firstCols == secondCols) {
            for (int k = 0; k < firstRows; k++) {
                for (int m = 0; m < firstCols; m++) {
                    int fCurNum = firstMatrix[k][m];
                    int sCurNum = secondMatrix[k][m];
                    if (fCurNum != sCurNum) {
                        isEqual = false;
                        break;
                    }
                }
            }
        } else {
            isEqual = false;
        }

        if (!isEqual) {
            System.out.println("not equal");
        } else {
            System.out.println("equal");
        }
    }
}
