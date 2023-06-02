package T05FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(", ");

        List<String> list = Arrays.stream(arr)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", list));

        List<String> newList = list.stream()
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", newList));
    }
}
