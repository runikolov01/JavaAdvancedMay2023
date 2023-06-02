package T03SetsAndMapsAdvanced;

import java.util.*;

public class L06ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        TreeMap<String, LinkedHashMap<String, Double>> map = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] arrInput = input.split(", ");
            String shop = arrInput[0];
            String produt = arrInput[1];
            double price = Double.parseDouble(arrInput[2]);
            if (!map.containsKey(shop)) {
                map.put(shop, new LinkedHashMap<>());
                map.get(shop).put(produt, price);
            } else {
                map.get(shop).put(produt, price);
            }
            input = scan.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> currentShop : map.entrySet()) {
            System.out.printf("%s->%n", currentShop.getKey());
            for (Map.Entry<String, Double> currentProduct : currentShop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", currentProduct.getKey(), currentProduct.getValue());
            }
        }
    }
}
