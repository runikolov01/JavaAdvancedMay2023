package T03SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.TreeMap;

public class E05Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        TreeMap<String, String> map = new TreeMap<>();

        while (!input.equals("search")) {
            String[] arrInp = input.split("-");
            String name = arrInp[0];
            String phoneNumber = arrInp[1];
            map.put(name, phoneNumber);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while(!input.equals("stop")){
            if(map.containsKey(input)){
                System.out.printf("%s -> %s%n", input, map.get(input));
            }
            else{
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scan.nextLine();
        }
    }
}
