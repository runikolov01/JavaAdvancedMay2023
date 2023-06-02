package T03SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        TreeMap<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);
            if (!map.containsKey(currentLetter)) {
                map.put(currentLetter, 1);
            } else {
                map.put(currentLetter, map.get(currentLetter) + 1);
            }
        }
        for (Map.Entry<Character, Integer> letter : map.entrySet()) {
            System.out.printf("%c: %d time/s%n", letter.getKey(), letter.getValue());
        }
    }
}
