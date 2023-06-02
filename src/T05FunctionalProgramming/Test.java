package T05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputArr = scan.nextLine().split("\\s+");
        int first = Integer.parseInt(inputArr[0]);
        int second = Integer.parseInt(inputArr[1]);

        Predicate<Integer> filterPredicat = null;
        String command = scan.nextLine();

        if (command.equals("odd")) {
            for(int i = first; i <= second; i++) {
                filterPredicat = e -> e % 2 != 0;
            }
        } else if (command.equals("even")) {
            for(int i = first; i <= second; i++) {
                filterPredicat = e -> e % 2 == 0;
            }
        }
        assert filterPredicat != null;
        Arrays.stream(inputArr)
                .map(Integer::parseInt)
                .filter(filterPredicat)
                .forEach(e -> System.out.printf("%d ", e));

    }
}
