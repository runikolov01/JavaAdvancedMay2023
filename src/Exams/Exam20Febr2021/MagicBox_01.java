package Exams.Exam20Febr2021;

import java.util.*;
import java.util.stream.Collectors;

public class MagicBox_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstBoxList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (Integer q : firstBoxList) {
            queue.offer(q);
        }

        List<Integer> secondBoxList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Stack<Integer> stack = new Stack<>();
        for (Integer s : secondBoxList) {
            stack.push(s);
        }

        List<Integer> collectedItems = new ArrayList<>();

        while (!stack.isEmpty() && !queue.isEmpty()) {
            int currentStackNumber = stack.peek();
            int currentQueueNumber = queue.peek();
            int sum = currentQueueNumber + currentStackNumber;
            if (sum % 2 == 0) {
                collectedItems.add(sum);
                stack.pop();
                queue.poll();
            } else {
                int lastStackItem = stack.pop();
                queue.offer(lastStackItem);
            }
        }
        if (queue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if (stack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        int num = 0;
        int total = 0;

        for (Integer item : collectedItems) {
            total += item;
        }
        if (total >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + total);
        } else {
            System.out.println("Poor prey... Value: " + total);
        }
    }
}
