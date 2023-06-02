package T04StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class L06SortLines {
    public static void main(String[] args) throws IOException {
        Path pathRead = Paths.get("C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path pathWrite = Paths.get("C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt");
        List<String> allLines = Files.readAllLines(pathRead);
        Collections.sort(allLines);
        Files.write(pathWrite, allLines);
    }
}
