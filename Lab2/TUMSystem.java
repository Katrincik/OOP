package Lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TUMSystem {

    private static List<Faculty> faculties = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Welcome to TUM's student management system!");
        System.out.println("What do you want to do?");
        System.out.println("g - General operations");
        System.out.println("f - Faculty operations");
        System.out.println("s - Student operations");
        System.out.println("");
        System.out.println("q - Quit Program");

        Scanner myInput = new Scanner(System.in);

        System.out.print("your input> ");
        String Choice_Input = myInput.nextLine();

        switch (Choice_Input) {
            case "f":
                facultyOperations(myInput);
                break;
            case "g":
                generalOperations(myInput);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void facultyOperations(Scanner scanner) {
        System.out.println("Faculty Operations:");
        System.out.println("What do you want to do?");
        System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student");
        System.out.println("gs/<email> - (g)raduate (s)tudent");
        System.out.println("ds<faculty abbreviation> - (d)isplay enrolled students");
        System.out.println("dg<faculty abbreviation> - (d)isplay (g)raduated students");
        System.out.println("bf<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty");
        System.out.println("");
        System.out.println("b - Back");
        System.out.println("q - Quit Program");

        System.out.print("your input> ");
        int Choice_Faculty = scanner.nextInt();

        switch (Choice_Faculty) {
            case 1:
                createAndAssignStudent(scanner);
                break;
            case 2:
                graduateStudent(scanner);
                break;
            case 3:
                displayCurrentEnrolledStudents(scanner);
                break;
            case 4:
                displayGraduates(scanner);
                break;
            case 5:
                checkStudentFaculty(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void generalOperations(Scanner scanner) {
        System.out.println("General Operations");
        System.out.println("What do you want to do?");
        System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - creat faculty");
        System.out.println("ss/<student email> - search student and show faculty");
        System.out.println("df - display faculties");
        System.out.println("df/<field> - display all faculties of a field");
        System.out.println("");
        System.out.println("b - Back");
        System.out.println("q - Quit Program");

        System.out.print("your input> ");
        String input = scanner.nextLine().trim(); 

        if (input.startsWith("nf/")) {
            createFaculty(input);
        } else if (input.startsWith("ss/")) {
            searchStudentFaculty(input);
        } else if (input.equals("df")) {
            displayFaculties();
        } else if (input.startsWith("df/")) {
            displayFacultiesByField(input);
        } else if (input.equals("b")) {
            return;
        } else if (input.equals("q")) {
            System.exit(0);
        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }

    private static void createAndAssignStudent(Scanner scanner) {

    }

    private static void graduateStudent(Scanner scanner) {

    }

    private static void displayCurrentEnrolledStudents(Scanner scanner) {

    }

    private static void displayGraduates(Scanner scanner) {

    }

    private static void checkStudentFaculty(Scanner scanner) {

    }

    private static void createFaculty(String input) {
        String[] parts = input.split("/");
        
        if (parts.length == 4) {
            String facultyName = parts[1];
            String facultyAbbreviation = parts[2];
            String facultyfield = parts[3];
            
            StudyField field = null;
            try {
                field = StudyField.valueOf(facultyfield);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid field. Please use one of: MECHANICAL_ENGINEERING, SOFTWARE_ENGINEERING, FOOD_TECHNOLOGY, URBANISM_ARCHITECTURE, VETERINARY_MEDICINE");
                return;
            }
            
            Faculty newFaculty = new Faculty(facultyName, facultyAbbreviation, field);
            
            faculties.add(newFaculty);
            
            System.out.println("Faculty created successfully!");
        } else {
            System.out.println("Invalid command format. Use: nf/<faculty name>/<faculty abbreviation>/<field>");
        }
    }    

    private static void searchStudentFaculty(String input) {
        String[] parts = input.split("/");
        
        if (parts.length == 2) {
            String studentEmail = parts[1];
            
            for (Faculty faculty : faculties) {
                List<Student> students = faculty.getStudents();
                
                for (Student student : students) {
                    if (student.getEmail().equals(studentEmail)) {
                        System.out.println("Student with email " + studentEmail + " belongs to the faculty:");
                        System.out.println("Faculty Name: " + faculty.getName());
                        System.out.println("Faculty Abbreviation: " + faculty.getAbbreviation());
                        System.out.println("Faculty Field: " + faculty.getStudyField());
                        return; 
                    }
                }
            }
            System.out.println("Student with email " + studentEmail + " not found.");
        } else {
            System.out.println("Invalid command format. Use: ss/<student email>");
        }
    }
    
    private static void displayFaculties() {
        if (faculties.isEmpty()) {
            System.out.println("No faculties found.");
        } else {
            System.out.println("University Faculties:");
            for (Faculty faculty : faculties) {
                System.out.println("Faculty Name: " + faculty.getName());
                System.out.println("Faculty Abbreviation: " + faculty.getAbbreviation());
                System.out.println("Faculty Field: " + faculty.getStudyField());
                System.out.println();
            }
        }
    }
    
    private static void displayFacultiesByField(String input) {
        String[] parts = input.split("/");
        
        if (parts.length == 2) {
            String fieldInput = parts[1];
            
            StudyField field = null;
            try {
                field = StudyField.valueOf(fieldInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid field. Please use one of: MECHANICAL_ENGINEERING, SOFTWARE_ENGINEERING, FOOD_TECHNOLOGY, URBANISM_ARCHITECTURE, VETERINARY_MEDICINE");
                return;
            }
            
            System.out.println("Faculties in the " + fieldInput + " field:");
            boolean found = false;
            
            for (Faculty faculty : faculties) {
                if (faculty.getStudyField() == field) {
                    System.out.println("Faculty Name: " + faculty.getName());
                    System.out.println("Faculty Abbreviation: " + faculty.getAbbreviation());
                    found = true;
                }
            }
            
            if (!found) {
                System.out.println("No faculties found in the " + fieldInput + " field.");
            }
        } else {
            System.out.println("Invalid command format. Use: df/<field>");
        }
    }

}