package T01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class L06HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] names = scan.nextLine().split(" ");
        Collections.addAll(stack, names);
        int number = Integer.parseInt(scan.nextLine());

        while (stack.size() > 1) {
            for (int i = 1; i <= number; i++) {
                String name = stack.peek();
                if (i == number) {
                    stack.poll();
                    System.out.printf("Removed %s%n", name);
                } else {
                    stack.poll();
                    stack.add(name);
                }
            }
        }
        System.out.printf("Last is %s", stack.peek());
    }
}
