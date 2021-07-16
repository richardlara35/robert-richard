package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class UserInput {

    public static Path path = addContacts.getPath("Contacts.txt");

    public static ArrayList<String> UserAdd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add a contact? Y/N?");
        String userChoice = scanner.next();
        ArrayList<String> newArray = null;
        if (userChoice.equalsIgnoreCase("y")){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the new contact's number: ");
            String newNumber = sc.nextLine();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Please enter the new contact's name: ");
            String newName = scanner1.nextLine();
            newArray = new ArrayList<>();
            newArray.add(newName);
            newArray.add(newNumber);
            tryWriteToFile(newArray, path);

        }else{
            System.out.println("Fine then");
            DisplayMenu.showOptions();
        }
        return newArray;
    }

    public static void tryWriteToFile(List<String> content, Path path) {
        try {
            Files.write(path, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Could not write to file at: " + path.toAbsolutePath());
        }
    }

    public static void searchContacts(){
        ArrayList<String> searchResult;
        List<String> fileContents = new ArrayList<>() {};
        fileContents.add("Error, please seek help");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who are you searching for?");
        String userSearch = scanner.nextLine();
        try {
            searchResult = (ArrayList<String>) ReadWriteDirectoryAndFiles.readFromFile(path);
//            System.out.println(Collections.sort(searchResult));
           if( searchResult.contains(userSearch)){
               System.out.println(searchResult.get(searchResult.indexOf(userSearch)));
           }
        } catch (IOException e) {
            System.out.println("Unable to read contents of the file at: " + path.toAbsolutePath());
        }
//        return userSearch;
    }
}
