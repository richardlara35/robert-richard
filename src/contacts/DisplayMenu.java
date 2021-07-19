package contacts;

import java.nio.file.Path;
import java.util.Scanner;

public class DisplayMenu {


    Path path = addContacts.getPath("Contacts.txt");


    public static int showOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do? \n" +
                "0 - View Contacts\n" +
                "1 - Add new Contact\n" +
                "2 - Search Contact by name\n" +
                "3 - Delete an existing contact\n" +
                "4 - Exit\n" +
                "Enter your choice: ");
//        System.out.println(scanner.nextInt());
        return scanner.nextInt();
    }

    public static void showResults() {
        int userChoice = showOptions();
        Path path = addContacts.getPath("Contacts.txt");
        switch (userChoice) {
            case 0:
                ReadWriteDirectoryAndFiles.tryPrintContents(path);
                break;
            case 1:
                UserInput.UserAdd();
                break;
            case 2:
                UserInput.searchContacts();
                break;
            case 3:
                deleteContacts.deleteContact();
                break;
            case 4:
                System.out.println("Goodbye, Have a wonderful day!");
                return;
            default:
                System.out.println("Invalid choice, please select a valid choice ");
                showOptions();
        }
        showResults();
    }


}
