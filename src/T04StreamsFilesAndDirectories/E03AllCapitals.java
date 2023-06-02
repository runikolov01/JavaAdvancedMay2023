package T04StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E03AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\T04StreamsFilesAndDirectories\\output.txt"));

        List<String> allLines = Files.readAllLines(Path.of(path));

        for (String line : allLines) {
            bw.write(line.toUpperCase());
            bw.newLine();
        }
        bw.close();
    }
}
