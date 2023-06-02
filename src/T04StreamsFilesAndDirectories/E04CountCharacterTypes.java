package T04StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E04CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        int vowelsCount = 0;
        int punctCount = 0;
        int consonantsCount = 0;

        String path = "C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        for (String line : allLines) {

            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                if (currentSymbol == ' ') {
                    continue;
                }
                if (currentSymbol == 'a' || currentSymbol == 'u' || currentSymbol == 'e' || currentSymbol == 'o' || currentSymbol == 'i') {
                    vowelsCount++;
                } else if (currentSymbol == ',' || currentSymbol == '!' || currentSymbol == '?' || currentSymbol == '.') {
                    punctCount++;
                } else {
                    consonantsCount++;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\T04StreamsFilesAndDirectories\\output.txt"));
        bw.write("Vowels: " + vowelsCount);
        bw.newLine();

        bw.write("Other symbols: " + consonantsCount);
        bw.newLine();

        bw.write("Punctuation: " + punctCount);
        bw.close();
    }
}
