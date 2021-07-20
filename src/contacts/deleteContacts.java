package contacts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class deleteContacts {

    public static Path path = addContacts.getPath("Contacts.txt");

    public static List<String> readFile(){

        List<String> fileContents = new ArrayList<>() {};
        fileContents.add("Error, please seek help");
        try {
            return ReadWriteDirectoryAndFiles.readFromFile(path);
        } catch (IOException e) {
            System.out.println("Unable to read contents of the file at: " + path.toAbsolutePath());
            return fileContents;
        }

    }
    public static void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to delete a contact? Y/N");
        String userChoice = scanner.nextLine();
        if (userChoice.equalsIgnoreCase("y")) {
            ReadWriteDirectoryAndFiles.tryPrintContents(path);
            Scanner chooseContact = new Scanner(System.in);
            System.out.println("Which contact would you like to delete?");
            String contactToDelete = chooseContact.nextLine();
            List<String> file = readFile();
            file.remove(file.indexOf(contactToDelete) +1);
            file.remove(contactToDelete);
            tryWriteToFile(file, path);


        }else {
            System.out.println("Deuces");
            DisplayMenu.showOptions();
        }
    }

    public static void tryWriteToFile(List<String> content, Path path) {
        try{
            Files.write(path, content);
        }catch (IOException e){
            System.out.println("Could not write to file at: " + path.toAbsolutePath());
        }

    }
}

