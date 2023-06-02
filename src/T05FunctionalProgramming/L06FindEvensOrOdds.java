package T05FunctionalProgramming;

import java.util.Scanner;

public class L06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputArr = scan.nextLine().split("\\s+");
        int first = Integer.parseInt(inputArr[0]);
        int second = Integer.parseInt(inputArr[1]);

        String command = scan.nextLine();

        if (command.equals("odd")) {
            for (int i = first; i <= second; i++) {
                if (i % 2 != 0) {
                    System.out.printf("%d ", i);
                }
            }
        } else if (command.equals("even")) {
            for (int i = first; i <= second; i++) {
                if (i % 2 == 0) {
                    System.out.printf("%d ", i);
                }
            }
        }
    }
}
