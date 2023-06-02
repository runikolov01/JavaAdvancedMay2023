package T04StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E05LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\T04StreamsFilesAndDirectories\\output.txt"));

        int counter = 1;

        for (int i = 0; i < allLines.size(); i++) {
            bw.write(counter + ". " + allLines.get(i));
            bw.newLine();
            counter++;
        }
        bw.close();
    }
}
