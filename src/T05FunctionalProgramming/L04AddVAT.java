package T05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class L04AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arrNumbers = scan.nextLine().split(", ");
        Function<String, Double> parseToDouble = e -> Double.parseDouble(e);
        Function<Double, Double> addVat = e -> 1.2 * e;
        Consumer<Double> printer = e -> System.out.printf("%.2f%n", e);

        System.out.println("Prices with VAT:");
        Arrays.stream(arrNumbers)
                .map(parseToDouble)
                .map(addVat)
                .forEach(printer);
    }
}
