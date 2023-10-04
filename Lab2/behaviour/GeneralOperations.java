package Lab2.behaviour;

import Lab2.models.Faculty;
import Lab2.models.Student;
import Lab2.models.StudyField;

import java.util.List;
import java.util.Scanner;

import static Lab2.behaviour.TUMSystem.faculties;

public class GeneralOperations {
    static void createFaculty(String input) {
        String[] parts = input.split("/");

        if (parts.length == 4) {
            String facultyName = parts[1];
            String facultyAbbreviation = parts[2];
            String facultyfield = parts[3];

            StudyField field;
            try {
                field = StudyField.valueOf(facultyfield);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid field. Please use one of: MECHANICAL_ENGINEERING, SOFTWARE_ENGINEERING, FOOD_TECHNOLOGY, URBANISM_ARCHITECTURE, VETERINARY_MEDICINE\n");
                return;
            }

            for (Faculty existingFaculty : faculties) {
                if (existingFaculty.getName().equals(facultyName) && existingFaculty.getAbbreviation().equals(facultyAbbreviation)) {
                    System.out.println("Faculty with the same name and abbreviation already exists.\n");
                    return;
                }
            }

            Faculty newFaculty = new Faculty(facultyName, facultyAbbreviation, field);
            faculties.add(newFaculty);

            System.out.println("Faculty created successfully!\n");
        } else {
            System.out.println("Invalid command format. Use: nf/<faculty name>/<faculty abbreviation>/<field>\n");
        }
    }

    static void searchStudentFaculty(String input) {
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
                        System.out.println("Faculty Field: " + faculty.getStudyField() +"\n");
                        return;
                    }
                }
            }
            System.out.println("Student with email " + studentEmail + " not found.\n");
        } else {
            System.out.println("Invalid command format. Use: ss/<student email>\n");
        }
    }

    static void displayFaculties() {
        if (faculties.isEmpty()) {
            System.out.println("No faculties found.\n");
        } else {
            System.out.println("University Faculties:");
            for (Faculty faculty : faculties) {
                System.out.println("Faculty Name: " + faculty.getName());
                System.out.println("Faculty Abbreviation: " + faculty.getAbbreviation());
                System.out.println("Faculty Field: " + faculty.getStudyField() + "\n");
            }
        }
    }

    static void displayFacultiesByField(String input) {
        String[] parts = input.split("/");

        if (parts.length == 2) {
            String fieldInput = parts[1];

            StudyField field;
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
                    System.out.println("Faculty Abbreviation: " + faculty.getAbbreviation() +"\n");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No faculties found in the " + fieldInput + " field.\n");
            }
        } else {
            System.out.println("Invalid command format. Use: df/<field>\n");
        }
    }
    public void generalOperations(Scanner scanner) {
        while (true) {
            System.out.println("""
                    General Operations
                    What do you want to do?
                    
                    nf/<faculty name>/<faculty abbreviation>/<field> - create faculty
                    ss/<student email> - search student and show faculty
                    df - display faculties
                    df/<field> - display all faculties of a field
                    
                    b - Back
                    q - Quit Program
                    """);

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
    }
}