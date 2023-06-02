package T03SetsAndMapsAdvanced;

import java.util.*;

public class E06FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, String> emailsData = new LinkedHashMap<>();

        String name = scan.nextLine();
        while (!name.equals("stop")) {
            String email = scan.nextLine();
            if (!email.endsWith("uk") && !email.endsWith("us") && !email.endsWith("com")) {
                emailsData.put(name, email);
            }

            name = scan.nextLine();
        }

        emailsData.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}