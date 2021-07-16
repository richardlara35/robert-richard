package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CreateDirectoriesAndFiles {

    public static void tryWriteToFile(ArrayList<String> content, Path path) {
        try {
            Files.write(path, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Could not write to file at: " + path.toAbsolutePath());
        }
    }


    public static void tryCreateDirectory(Path pathToCreate) {

        if (!doesPathExist(pathToCreate)) {

            try {
                Files.createDirectory(pathToCreate);
            } catch (IOException e) {
                System.out.println("Could not create the directory at: ");
                System.out.println(pathToCreate.toAbsolutePath());
            }

        } else {
            System.out.println("The path at: " + pathToCreate.toAbsolutePath() + " already exists");
        }
    }

    public static void tryCreateFile(Path path){

        if (!doesPathExist(path)){
            try{
                Files.createFile(path);
            }catch (IOException e){
                System.out.println("Could not create file at: " + path.toAbsolutePath());
            }
        } else {
            System.out.println("The file at: " + path.toAbsolutePath() + " already exists");
        }
    }

    public static boolean doesPathExist(Path path) {
        return Files.exists(path);
    }
}
