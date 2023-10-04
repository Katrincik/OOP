package Lab2.behaviour;

import Lab2.models.Faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TUMSystem {
    public static final List<Faculty> faculties = new ArrayList<>();
    static final FacultyOperations facultyManager = new FacultyOperations();
    static final GeneralOperations generalManager = new GeneralOperations();
    static final Scanner myInput = new Scanner(System.in);

    public static void run() {
        System.out.println("Welcome to TUM's student management system!");

        while (true) {
            displayMainMenu();

            String choiceInput = myInput.nextLine().trim();

            switch (choiceInput) {
                case "f":
                    facultyManager.facultyOperations();
                    break;
                case "g":
                    generalManager.generalOperations(myInput);
                    break;
                case "q":
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.print("""

                What do you want to do?
                g - General operations
                f - Faculty operations
                
                q - Quit Program
                
                your input>\s""");
    }
}
