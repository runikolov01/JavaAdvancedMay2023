package T04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class L04ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String pathRead = "C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(pathRead);
        Scanner scan = new Scanner(inputStream);
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                int number = scan.nextInt();
                System.out.println(number);
            }
            scan.next();
        }
    }
}
