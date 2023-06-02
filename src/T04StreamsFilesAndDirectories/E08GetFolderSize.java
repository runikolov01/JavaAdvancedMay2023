package T04StreamsFilesAndDirectories;

import java.io.File;

public class E08GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\35998\\OneDrive\\Документи\\Java Advanced - May_2023\\Java Advanced - May_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);

        File[] allFiles = folder.listFiles();

        int folderSize = 0;

        for (File file : allFiles) {
            folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
