package Exam25June2022;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> milkList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        ArrayDeque<Double> queueMilk = new ArrayDeque<>();
        for (Double milk : milkList) {
            queueMilk.offer(milk);
        }

        List<Double> cacaoList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Stack<Double> stackCacao = new Stack<>();
        for (Double cacao : cacaoList) {
            stackCacao.push(cacao);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("Milk Chocolate", 30);
        map.put("Dark Chocolate", 50);
        map.put("Baking Chocolate", 100);

        Map<String, Integer> producedMap = new TreeMap<>();


        String type = "";

        while (!stackCacao.isEmpty() && !queueMilk.isEmpty()) {
            double curMilk = queueMilk.peek();
            double curCocoa = stackCacao.peek();

            double doubleCacaoPercentage = (curCocoa / (curMilk + curCocoa)) * 100;
            int cacaoPercentage = (int) doubleCacaoPercentage;

            if (map.containsValue(cacaoPercentage)) {
                int searchedValue = cacaoPercentage;
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue().equals(searchedValue)) {
                        type = entry.getKey();
                        break;
                    }
                }
                stackCacao.pop();
                queueMilk.poll();
                if (!producedMap.containsKey(type)) {
                    producedMap.put(type, 1);
                } else {
                    producedMap.put(type, producedMap.get(type) + 1);
                }
            } else {
                stackCacao.pop();
                double temp = curCocoa + 10;
                queueMilk.poll();
                queueMilk.offer(temp);

            }
        }

        if (producedMap.size() >= 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : producedMap.entrySet()) {
            System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
