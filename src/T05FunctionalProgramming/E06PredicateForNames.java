package T05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class E06PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");

        Predicate<String> checkValidLength = name -> name.length() <= num;
        Arrays.stream(names).filter(checkValidLength).forEach(System.out::println);

    }
}
