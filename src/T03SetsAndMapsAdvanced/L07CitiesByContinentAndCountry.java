package T03SetsAndMapsAdvanced;

import java.util.*;

public class L07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String input = scan.nextLine();
            String[] arrInput = input.split("\\s+");
            String continent = arrInput[0];
            String country = arrInput[1];
            String city = arrInput[2];

            if (!map.containsKey(continent)) {
                map.put(continent, new LinkedHashMap<>());
                map.get(continent).put(country, new ArrayList<>());
                map.get(continent).get(country).add(city);
            } else {
                if (!map.get(continent).containsKey(country)) {
                    map.get(continent).put(country, new ArrayList<>());
                    map.get(continent).get(country).add(city);
                } else {
                    map.get(continent).get(country).add(city);
                }
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, List<String>>> continent : map.entrySet()) {
            System.out.printf("%s:%n", continent.getKey());
            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.printf("%s -> ", country.getKey());
                System.out.print(String.join(", ", country.getValue()));
                System.out.println();
            }
        }
    }
}
