package Exams.Exam23Oct2021;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, String> cocktailMap = new HashMap<>();
        cocktailMap.put(150, "Pear Sour");
        cocktailMap.put(250, "The Harvest");
        cocktailMap.put(300, "Apple Hinny");
        cocktailMap.put(400, "High Fashion");

        List<Integer> ingredientsList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> queueIngredients = new ArrayDeque<>();
        for (Integer ingr : ingredientsList) {
            queueIngredients.offer(ingr);
        }


        List<Integer> levelList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Stack<Integer> stackLevel = new Stack<>();
        for (Integer stack : levelList) {
            stackLevel.push(stack);
        }
        Map<String, Integer> madeCocktailes = new TreeMap<>();


        while (!stackLevel.isEmpty() && !queueIngredients.isEmpty()) {
            int curLevel = stackLevel.peek();
            int curIngr = queueIngredients.peek();
            int sum = curLevel * curIngr;
            if (curIngr == 0) {
                queueIngredients.poll();
                continue;
            }
            if (cocktailMap.containsKey(sum)) {
                queueIngredients.poll();
                stackLevel.pop();
                String name = cocktailMap.get(sum);
                if (!madeCocktailes.containsKey(name)) {
                    madeCocktailes.put(name, 1);
                } else {
                    madeCocktailes.put(name, madeCocktailes.get(name) + 1);
                }
            } else {
                stackLevel.pop();
                queueIngredients.poll();
                curIngr += 5;
                queueIngredients.offer(curIngr);
            }
        }
        if (madeCocktailes.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!queueIngredients.isEmpty()) {
            int sum = 0;
            for (Integer ingr : queueIngredients) {
                sum += ingr;
            }
            System.out.println("Ingredients left: " + sum);
        }

        for (Map.Entry<String, Integer> entry : madeCocktailes.entrySet()) {
            System.out.println("# " + entry.getKey() + " --> " + entry.getValue());
        }
    }
}
