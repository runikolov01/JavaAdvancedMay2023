package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = false;


        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                stack.push(currentSymbol);
            } else if (currentSymbol == ')' || currentSymbol == ']' || currentSymbol == '}') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpened = stack.peek();
                if (lastOpened == '(' && currentSymbol == ')') {
                    stack.pop();
                    isBalanced = true;
                } else if (lastOpened == '[' && currentSymbol == ']') {
                    stack.pop();
                    isBalanced = true;

                } else if (lastOpened == '{' && currentSymbol == '}') {
                    stack.pop();
                    isBalanced = true;
                } else {
                    isBalanced = false;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
