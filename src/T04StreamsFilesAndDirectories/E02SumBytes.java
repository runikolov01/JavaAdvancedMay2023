package T04StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E02SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while (line != null) {
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                sum += currentSymbol;
            }
            line = br.readLine();
        }
        System.out.println(sum);
    }
}
