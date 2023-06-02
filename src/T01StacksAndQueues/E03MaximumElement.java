package T01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E03MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scan.nextLine());
        int second = 0;

        for (int i = 1; i <= n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String first = input[0];
            if (first.equals("1")) {
                second = Integer.parseInt(input[1]);
                stack.push(second);

            } else if (first.equals("2") && !stack.isEmpty()) {
                stack.pop();
            } else if (first.equals("3") && !stack.isEmpty()) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
