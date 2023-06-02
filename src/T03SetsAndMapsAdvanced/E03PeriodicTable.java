package T03SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class E03PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] arrInp = input.split("\\s+");
            set.addAll(Arrays.asList(arrInp));
        }
        set.forEach(el -> System.out.printf("%s ", el));
    }
}
