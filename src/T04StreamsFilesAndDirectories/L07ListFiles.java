package T04StreamsFilesAndDirectories;

import java.io.File;

public class L07ListFiles {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        if (folder.exists()) {
            // съществува файла
            if (folder.isDirectory()) {
                // файлът е папка
                File[] allFiles = folder.listFiles();
                for (File file : allFiles) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%d]%n", file.getName(), file.length());
                    }
                }
            }
        }
    }
}
