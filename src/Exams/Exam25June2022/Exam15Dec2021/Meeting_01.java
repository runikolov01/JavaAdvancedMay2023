package Exams.Exam25June2022.Exam15Dec2021;

import java.util.*;
import java.util.stream.Collectors;

public class Meeting_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stackMale = new Stack<>();
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).filter(e -> e > 0).forEach(e -> stackMale.push(e));

        ArrayDeque<Integer> queueFemale = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).filter(e -> e > 0).forEach(e -> queueFemale.offer(e));

        int matched = 0;

        while (!stackMale.isEmpty() && !queueFemale.isEmpty()) {
            int curMale = stackMale.peek();
            int curFemale = queueFemale.peek();
            if (curFemale <= 0) {
                queueFemale.poll();
                continue;
            }
            if (curMale <= 0) {
                stackMale.pop();
                continue;
            }
            if (curMale % 25 == 0) {
                stackMale.pop();
                if (stackMale.isEmpty()) {
                    break;
                } else {
                    stackMale.pop();
                }
                continue;
            }
            if (curFemale % 25 == 0) {
                queueFemale.poll();
                if (queueFemale.isEmpty()) {
                    break;
                } else {
                    queueFemale.poll();
                }
                continue;
            }

            if (curMale == curFemale) {
                matched++;
                stackMale.pop();
                queueFemale.poll();
            } else {
                queueFemale.poll();
                stackMale.pop();
                int newValue = curMale - 2;
                if (newValue > 0) {
                    stackMale.push(newValue);
                }
            }
        }

        System.out.println("Matches: " + matched);
        if (stackMale.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            List<String> collect = stackMale.stream().map(String::valueOf).collect(Collectors.toList());
            Collections.reverse(collect);
            System.out.println("Males left: " + String.join(", ", collect));
        }

        if (queueFemale.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String collect = queueFemale.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Females left: " + collect);
        }
    }
}
