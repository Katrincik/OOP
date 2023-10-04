package Lab2.behaviour;

import java.time.LocalDate;
import Lab2.models.Faculty;
import Lab2.models.Student;

import java.util.List;
import java.util.Scanner;

import static Lab2.behaviour.TUMSystem.faculties;

public class FacultyOperations {
    static void createAndAssignStudent(String input) {
        String[] parts = input.split("/");

        if (parts.length == 8) {
            String facultyAbbreviation = parts[1];
            String firstName = parts[2];
            String lastName = parts[3];
            String email = parts[4];
            String dateofbirthStr = parts[5] + "/" + parts[6] + "/" + parts[7];
            LocalDate enrollmentDate = LocalDate.now();

            Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

            if (faculty != null) {
                Student student = new Student(firstName, lastName, email, dateofbirthStr, enrollmentDate, false);

                faculty.addStudent(student);

                System.out.println("Student created and assigned to faculty " + facultyAbbreviation + ".\n");
            } else {
                System.out.println("Faculty with abbreviation " + facultyAbbreviation + " not found.\n");
            }
        } else {
            System.out.println("Invalid command format. Use: ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year>\n");
        }
    }

    private static Faculty findFacultyByAbbreviation(String abbreviation) {
        for (Faculty faculty : faculties) {
            if (faculty.getAbbreviation().equals(abbreviation)) {
                return faculty;
            }
        }
        return null;
    }

    static void graduateStudent(String input) {
        String[] parts = input.split("/");

        if (parts.length == 2) {
            String studentEmail = parts[1];

            Faculty faculty = findFacultyByStudentEmail(studentEmail);

            if (faculty != null) {
                Student studentToRemove = null;

                for (Student student : faculty.getStudents()) {
                    if (student.getEmail().equals(studentEmail)) {
                        studentToRemove = student;
                        break;
                    }
                }

                if (studentToRemove != null) {
                    studentToRemove.setGraduated(true);
                    System.out.println("Student with email " + studentEmail + " has been graduated from " + faculty.getName() + ".\n");
                } else {
                    System.out.println("Student with email " + studentEmail + " not found in " + faculty.getName() + ".\n");
                }
            } else {
                System.out.println("No faculty found for the student with email " + studentEmail + ".\n");
            }
        } else {
            System.out.println("Invalid command format. Use: gs/<email>\n");
        }
    }

    private static Faculty findFacultyByStudentEmail(String studentEmail) {
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(studentEmail)) {
                    return faculty;
                }
            }
        }
        return null;
    }

    static void displayCurrentEnrolledStudents(String input) {
        String[] parts = input.split("/");

        if (parts.length == 2) {
            String facultyAbbreviation = parts[1];

            Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

            if (faculty != null) {
                List<Student> students = faculty.getStudents();
                boolean enrolledStudentsFound = false;

                System.out.println("Currently Enrolled Students in Faculty " + facultyAbbreviation + ":");
                for (Student student : students) {
                    if (!student.isGraduated()) {
                        System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
                        System.out.println("Student Email: " + student.getEmail());
                        System.out.println("Date of birth: " + student.getDateOfBirth());
                        System.out.println("Enrollment Date: " + student.getEnrollmentDate() +"\n");
                        enrolledStudentsFound = true;
                    }
                }

                if (!enrolledStudentsFound) {
                    System.out.println("No currently enrolled students in Faculty " + facultyAbbreviation + ".\n");
                }
            } else {
                System.out.println("Faculty with abbreviation " + facultyAbbreviation + " not found.\n");
            }
        } else {
            System.out.println("Invalid command format. Use: ds/<faculty abbreviation>\n");
        }
    }

    static void displayGraduates(String input) {
        String[] parts = input.split("/");

        if (parts.length == 2) {
            String facultyAbbreviation = parts[1];

            Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

            if (faculty != null) {
                List<Student> students = faculty.getStudents();

                if (!students.isEmpty()) {
                    System.out.println("Graduated Students in Faculty " + facultyAbbreviation + ":");
                    for (Student student : students) {
                        if (student.isGraduated()) {
                            System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
                            System.out.println("Student Email: " + student.getEmail());
                            System.out.println("Date of birth: " + student.getDateOfBirth());
                            System.out.println("Enrollment Date: " + student.getEnrollmentDate() +"\n");
                        }
                    }

                    boolean noGraduatesFound = students.stream().noneMatch(Student::isGraduated);
                    if (noGraduatesFound) {
                        System.out.println("No graduated students in Faculty " + facultyAbbreviation + ".\n");
                    }
                } else {
                    System.out.println("No students in Faculty " + facultyAbbreviation + ".\n");
                }
            } else {
                System.out.println("Faculty with abbreviation " + facultyAbbreviation + " not found.\n");
            }
        } else {
            System.out.println("Invalid command format. Use: dg/<faculty abbreviation>\n");
        }
    }

    static void checkStudentFaculty(String input) {
        String[] parts = input.split("/");

        if (parts.length == 3) {
            String facultyAbbreviation = parts[1];
            String studentEmail = parts[2];

            Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

            if (faculty != null) {
                boolean belongsToFaculty = studentBelongsToFaculty(studentEmail, faculty);

                if (belongsToFaculty) {
                    System.out.println("Student with email " + studentEmail + " belongs to Faculty " + facultyAbbreviation + ".\n");
                } else {
                    System.out.println("Student with email " + studentEmail + " does not belong to Faculty " + facultyAbbreviation + ".\n");
                }
            } else {
                System.out.println("Faculty with abbreviation " + facultyAbbreviation + " not found.\n");
            }
        } else {
            System.out.println("Invalid command format. Use: bf/<faculty abbreviation>/<email>\n");
        }
    }

    private static boolean studentBelongsToFaculty(String studentEmail, Faculty faculty) {
        List<Student> students = faculty.getStudents();
        for (Student student : students) {
            if (student.getEmail().equals(studentEmail)) {
                return true;
            }
        }
        return false;
    }

    public void facultyOperations() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Faculty Operations:
                    What do you want to do?
                    ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student
                    gs/<email> - (g)raduate (s)tudent
                    ds/<faculty abbreviation> - (d)isplay enrolled students
                    dg/<faculty abbreviation> - (d)isplay (g)raduated students
                    bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty
                    b - Back""");

            System.out.print("your input> ");
            String choiceFaculty = scanner.nextLine().trim();

            if (choiceFaculty.startsWith("ns/")) {
                createAndAssignStudent(choiceFaculty);
            } else if (choiceFaculty.startsWith("gs/")) {
                graduateStudent(choiceFaculty);
            } else if (choiceFaculty.startsWith("ds/")) {
                displayCurrentEnrolledStudents(choiceFaculty);
            } else if (choiceFaculty.startsWith("dg/")) {
                displayGraduates(choiceFaculty);
            } else if (choiceFaculty.startsWith("bf/")) {
                checkStudentFaculty(choiceFaculty);
            } else if (choiceFaculty.equals("b")) {
                return;
            } else if (choiceFaculty.equals("q")) {
                System.exit(0);
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
