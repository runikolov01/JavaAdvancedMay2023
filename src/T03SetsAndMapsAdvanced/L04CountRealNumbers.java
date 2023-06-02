package T03SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class L04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (occurrences.containsKey(numbers[i])) {
                int currentOcc = occurrences.get(numbers[i]);
                currentOcc++;
                occurrences.put(numbers[i], currentOcc);
            } else {
                occurrences.put(numbers[i], 1);
            }
        }

        for (Double number : occurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", number, occurrences.get(number));
        }

    }
}
