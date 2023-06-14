package Exams.Exam16Dec2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Bread	25
        //Cake	50
        //Pastry	75
        //Fruit Pie	100

        TreeMap<String, Integer> productsMap = new TreeMap<>();
        productsMap.put("Bread", 0);
        productsMap.put("Cake", 0);
        productsMap.put("Pastry", 0);
        productsMap.put("Fruit Pie", 0);


        List<Integer> firstList = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        for (Integer liq : firstList) {
            liquidsQueue.offer(liq);
        }

        List<Integer> secondList = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Stack<Integer> ingredientsStack = new Stack<>();
        for (Integer ingr : secondList) {
            ingredientsStack.push(ingr);
        }

        while (!ingredientsStack.isEmpty() && !liquidsQueue.isEmpty()) {
            int currentLiquids = liquidsQueue.peek();
            int currentIngredients = ingredientsStack.peek();
            int sum = currentIngredients + currentLiquids;
            String type = "";

            switch (sum) {
                case 25:
                    type = "Bread";
                    break;
                case 50:
                    type = "Cake";
                    break;
                case 75:
                    type = "Pastry";
                    break;
                case 100:
                    type = "Fruit Pie";
                    break;
            }
            if (sum == 25 || sum == 50 || sum == 75 || sum == 100) {
                productsMap.put(type, productsMap.get(type) + 1);
                ingredientsStack.pop();
                liquidsQueue.poll();
            } else {
                liquidsQueue.poll();
                int newValue = ingredientsStack.pop() + 3;
                ingredientsStack.push(newValue);
            }
        }

        if (!productsMap.containsValue(0)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            List<String> convertedList = new ArrayList<>();
            for (Integer num : liquidsQueue) {
                convertedList.add(String.valueOf(num));
            }
            System.out.println("Liquids left: " + String.join(", ", convertedList));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            List<String> convertedList = new ArrayList<>();
            for (Integer num : ingredientsStack) {
                convertedList.add(String.valueOf(num));
            }
            Collections.reverse(convertedList);
            System.out.println("Ingredients left: " + String.join(", ", convertedList));
        }

        for (Map.Entry<String, Integer> entry : productsMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
}
