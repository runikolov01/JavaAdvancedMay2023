package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // брой на елементите, които трябва да добавя към стека
        int s = scan.nextInt(); // показва на колко от числата трябва да бъде приложено pop()
        int x = scan.nextInt(); // число за проверка дали го има в стека

        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int count = 1; count <= n; count++) {
            stack.offer(scan.nextInt());
        }

        for (int k = 1; k <= s; k++) {
            stack.poll();
        }

        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (!stack.isEmpty()) {
                System.out.println(Collections.min(stack));
            } else {
                System.out.println("0");
            }
        }
    }
}
