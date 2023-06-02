package T03SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int sizeFirstSet = Integer.parseInt(input.split("\\s+")[0]);
        int sizeSecondSet = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < sizeFirstSet; i++) {
            int number = Integer.parseInt(scan.nextLine());
            firstSet.add(number);
        }
        for (int k = 0; k < sizeSecondSet; k++) {
            int number = Integer.parseInt(scan.nextLine());
            secondSet.add(number);
        }

        // взимаме елементите, които ги има и в двата сета - намираме общите елементи
        Set<Integer> duplicateElements = new LinkedHashSet<>();
        for (int number : firstSet) {
            if (secondSet.contains(number)) {
                duplicateElements.add(number);
            }
        }
        duplicateElements.forEach(number -> System.out.printf("%d ", number));

    }
}
