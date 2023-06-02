package T03SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> usernames = new LinkedHashSet<>();
        int countUsernames = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < countUsernames; i++) {
            String username = scan.nextLine();
            if (!usernames.contains(username)) {
                usernames.add(username);
            }
        }
        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
