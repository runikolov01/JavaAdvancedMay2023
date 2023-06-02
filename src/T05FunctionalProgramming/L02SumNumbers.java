package T05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L02SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(", ");

        List<Integer> listInteger = Arrays.stream(arr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Count = " + listInteger.size());

        int sum = Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("Sum = " + sum);

    }
}
