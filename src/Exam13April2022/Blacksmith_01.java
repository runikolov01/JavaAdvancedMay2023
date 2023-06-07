package Exam13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<Integer, String> swordMap = new TreeMap<>();
        swordMap.put(70, "Gladius");
        swordMap.put(80, "Shamshir");
        swordMap.put(90, "Katana");
        swordMap.put(110, "Sabre");

        List<Integer> steelList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> queueSteel = new ArrayDeque<>();
        for (Integer steel : steelList) {
            queueSteel.offer(steel);
        }

        List<Integer> carbonList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Stack<Integer> stackCarbon = new Stack<>();

        for (Integer carbon : carbonList) {
            stackCarbon.push(carbon);
        }

        Map<String, Integer> producedMap = new TreeMap<>();
        String produced = "";

        while (!queueSteel.isEmpty() && !stackCarbon.isEmpty()) {
            int curSteel = queueSteel.peek();
            int curCarbon = stackCarbon.peek();
            int sum = curSteel + curCarbon;
            if (swordMap.containsKey(sum)) {
                queueSteel.poll();
                stackCarbon.pop();
                produced = swordMap.get(sum);
                if (!producedMap.containsKey(produced)) {
                    producedMap.put(produced, 1);
                } else {
                    producedMap.put(produced, producedMap.get(produced) + 1);
                }
            } else {
                queueSteel.poll();
                int newValue = curCarbon + 5;
                stackCarbon.pop();
                stackCarbon.push(newValue);
            }
        }

        if (!producedMap.isEmpty()) {
            int sum = 0;
            for (Map.Entry<String, Integer> pr : producedMap.entrySet()) {
                sum += pr.getValue();
            }
            System.out.printf("You have forged %d swords.%n", sum);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (!queueSteel.isEmpty()) {
            String collect = queueSteel.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Steel left: " + collect);
        } else {
            System.out.println("Steel left: none");
        }
        if (!stackCarbon.isEmpty()) {
            List<String> collect = stackCarbon.stream().map(String::valueOf).collect(Collectors.toList());
            Collections.reverse(collect);
            System.out.println("Carbon left: " + String.join(", ", collect));
        } else {
            System.out.println("Carbon left: none");
        }
        producedMap.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .forEach(e1 -> System.out.println(e1.getKey() + ": " + e1.getValue()));

    }
}
