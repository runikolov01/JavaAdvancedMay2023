package T03SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;

public class L09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).sorted(
                (left, right) -> right.compareTo(left)
        ).limit(3).forEach(number -> System.out.printf("%d ", number));
    }
}
