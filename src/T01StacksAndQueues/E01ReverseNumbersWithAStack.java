package T01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arrNum = scan.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String item : arrNum) {
            stack.push(item);
        }

       while(!stack.isEmpty()){
           System.out.printf(stack.pop() + " ");
       }
    }
}
