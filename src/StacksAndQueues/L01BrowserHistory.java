package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L01BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String currentURL = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistory.size() > 1) {
                    browserHistory.pop();
                    currentURL = browserHistory.peek();
                    System.out.println(currentURL);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                browserHistory.push(input);
                currentURL = browserHistory.peek();
                System.out.println(currentURL);
            }
            input = scan.nextLine();
        }
    }
}
