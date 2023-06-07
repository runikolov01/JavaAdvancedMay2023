package Exam22Oct2022;

import java.util.*;
import java.util.stream.Collectors;

public class EnergyDrinks_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> miligramsList = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Stack<Integer> stackMiligrams = new Stack<>();
        for (Integer mil : miligramsList) {
            stackMiligrams.push(mil);
        }

        List<Integer> numDrinksList = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> queueNumDrinks = new ArrayDeque<>();
        for (Integer num : numDrinksList) {
            queueNumDrinks.offer(num);
        }

        int maxCoffeinePerNight = 300;
        int totalCoffeine = 0;
        int checkTotal = 0;

        while (!stackMiligrams.isEmpty() && !queueNumDrinks.isEmpty()) {
            int curMil = stackMiligrams.peek();
            int curNum = queueNumDrinks.peek();
            int sum = curMil * curNum;

            if (sum + totalCoffeine <= 300) {
                totalCoffeine += sum;
                stackMiligrams.pop();
                queueNumDrinks.poll();
            } else {
                stackMiligrams.pop();
                queueNumDrinks.poll();
                queueNumDrinks.offer(curNum);
                if (totalCoffeine >= 30) {
                    totalCoffeine -= 30;
                }
            }
        }
        if (!queueNumDrinks.isEmpty()) {
            ArrayDeque<String> newDeque = new ArrayDeque<>();
            for (Integer num : queueNumDrinks) {
                newDeque.add(num.toString());
            }
            String joined = String.join(", ", newDeque);
            System.out.printf("Drinks left: %s%n", joined);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCoffeine);
    }
}
