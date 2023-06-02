package T03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class E09PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> map = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("report")) {
            String[] arrInput = input.split("\\|");
            String city = arrInput[0];
            String country = arrInput[1];
            Long population = Long.parseLong(arrInput[2]);

            if (!map.containsKey(country)) {
                map.put(country, new LinkedHashMap<>() {{
                    put(city, population);
                }});
            } else {
                map.get(country).put(city, population);
            }
            input = scan.nextLine();
        }

        map.entrySet().stream().sorted((e1, e2) -> {
            Long totalPopulationFirst = map.get(e1.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            Long totalPopulationSecond = map.get(e2.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            return Long.compare(totalPopulationSecond, totalPopulationFirst);
        }).forEach(entry -> {
            System.out.print(entry.getKey() + " ");

            StringBuilder builder = new StringBuilder();

            AtomicReference<Long> totalPopulation = new AtomicReference<>((long) 0);

            map.get(entry.getKey()).entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> {
                        builder.append(String.format("=>%s: %d%n", e.getKey(), e.getValue()));
                        totalPopulation.updateAndGet(v -> v + e.getValue());
                    });

            System.out.println(String.format("(total population: %s)", totalPopulation.toString()));
            System.out.print(builder.toString());
        });

    }
}
