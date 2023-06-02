package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L05PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scan.nextLine();

        while (!input.equals("print")) {
            if (!input.equals("cancel")) {
                stack.offer(input);
            } else {
                if (!stack.isEmpty()) {
                    String currentInStack = stack.peek();
                    System.out.printf("Canceled %s%n", currentInStack);
                    stack.poll();
                } else {
                    System.out.println("Printer is on standby");
                }

            }
            input = scan.nextLine();
        }
        for (String el : stack) {
            System.out.println(el);
        }
    }
}
