package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadWriteDirectoryAndFiles {

    public static List<String> readFromFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static void tryPrintContents(Path path) {
        try {
            ReadWriteDirectoryAndFiles.printFileContents(ReadWriteDirectoryAndFiles.readFromFile(path));
        } catch (IOException e) {
            System.out.println("Unable to read contents of the file at: " + path.toAbsolutePath());
        }
    }

    public static void printFileContents(List<String> contents){
        for (String line : contents){
            System.out.println(line);
        }
    }
}
