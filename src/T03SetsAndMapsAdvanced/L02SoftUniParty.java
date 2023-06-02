package T03SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class L02SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Set<String> vipSet = new TreeSet<>();
        Set<String> regularSet = new TreeSet<>();

        while (!input.equals("PARTY")) {
            char firstLetter = input.charAt(0);
            if (Character.isDigit(firstLetter)) {
                vipSet.add(input);
            } else {
                regularSet.add(input);
            }
            input = scan.nextLine();
        }
        input = scan.nextLine();

        while (!input.equals("END")) {
            if (vipSet.contains(input)) {
                vipSet.remove(input);
            }
            if (regularSet.contains(input)) {
                regularSet.remove(input);
            }
            input = scan.nextLine();
        }
        int numVip = vipSet.size();
        int numReg = regularSet.size();

        System.out.println(numReg + numVip);
        for (String vip : vipSet) {
            System.out.println(vip);
        }
        for (String reg : regularSet) {
            System.out.println(reg);
        }
    }
}
