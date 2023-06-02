package T01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class L02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        ArrayDeque<String> tokens = new ArrayDeque<>();
        Collections.addAll(tokens, input);

        while (tokens.size() > 1) {
            int firstNum = Integer.parseInt(tokens.pop());
            String operator = tokens.pop();
            int secondNum = Integer.parseInt(tokens.pop());
            int result = 0;

            if (operator.equals("+")) {
                result = firstNum + secondNum;
            } else if (operator.equals("-")) {
                result = firstNum - secondNum;
            }
            tokens.push(String.valueOf(result));
        }
        System.out.println(tokens.peek());
    }
}
