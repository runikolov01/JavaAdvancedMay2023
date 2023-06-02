package T05FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class E01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] names = input.split("\\s+");

        // начин 1
        /*
        for (String name : names) {
            System.out.println(name);
        }
         */

        Consumer<String> printName = name -> System.out.println(name);
        for (String name : names) {
            printName.accept(name);
        }
    }
}
