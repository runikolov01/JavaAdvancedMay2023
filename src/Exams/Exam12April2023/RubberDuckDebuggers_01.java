package Exams.Exam12April2023;

import java.util.*;
import java.util.stream.Collectors;

//09:23

public class RubberDuckDebuggers_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> queueTime = new ArrayDeque<>();
        for (Integer num : firstList) {
            queueTime.add(num);
        }

        List<Integer> secondList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Stack<Integer> stackTask = new Stack<>();
        for (Integer task : secondList) {
            stackTask.push(task);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("Darth Vader Ducky", 0);
        map.put("Thor Ducky", 0);
        map.put("Big Blue Rubber Ducky", 0);
        map.put("Small Yellow Rubber Ducky", 0);

        while (!stackTask.isEmpty() && !queueTime.isEmpty()) {
            int curStack = stackTask.peek();
            int curQueue = queueTime.peek();
            int result = curStack * curQueue;
            if (result >= 0 && result <= 60) {
                int current = map.get("Darth Vader Ducky");
                int newCur = current + 1;
                map.put("Darth Vader Ducky", newCur);
                stackTask.pop();
                queueTime.poll();
            } else if (result >= 61 && result <= 120) {
                int current = map.get("Thor Ducky");
                int newCur = current + 1;
                map.put("Thor Ducky", newCur);
                stackTask.pop();
                queueTime.poll();
            } else if (result >= 121 && result <= 180) {
                int current = map.get("Big Blue Rubber Ducky");
                int newCur = current + 1;
                map.put("Big Blue Rubber Ducky", newCur);
                stackTask.pop();
                queueTime.poll();
            } else if (result >= 181 && result <= 240) {
                int current = map.get("Small Yellow Rubber Ducky");
                int newCur = current + 1;
                map.put("Small Yellow Rubber Ducky", newCur);
                stackTask.pop();
                queueTime.poll();
            } else {
                queueTime.poll();
                queueTime.add(curQueue);
                stackTask.push(stackTask.pop() - 2);
            }
            result = 0;

        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d%n", map.get("Darth Vader Ducky"));
        System.out.printf("Thor Ducky: %d%n", map.get("Thor Ducky"));
        System.out.printf("Big Blue Rubber Ducky: %d%n", map.get("Big Blue Rubber Ducky"));
        System.out.printf("Small Yellow Rubber Ducky: %d", map.get("Small Yellow Rubber Ducky"));

    }
}
