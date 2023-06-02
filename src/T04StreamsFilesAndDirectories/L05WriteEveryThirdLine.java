package T04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class L05WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        String pathRead = "C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathWrite = "C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\everyThirdLine.txt";
        FileInputStream inputStream = new FileInputStream(pathRead);
        FileOutputStream outputStream = new FileOutputStream(pathWrite);

        Scanner reader = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        int count = 1;
        String line = reader.nextLine();

        while (reader.hasNextLine()) {
            if (count % 3 == 0) {
                writer.println(line);
            }
            count++;
            line = reader.nextLine();
        }
        writer.close();
        reader.close();
    }
}
