package T05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split("\\s+");
        Consumer<String> printName = name -> System.out.printf("Sir %s%n", name);

        Arrays.stream(names).forEach(printName);
    }
}
