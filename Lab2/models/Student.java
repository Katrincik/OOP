package Lab2.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final LocalDate dateofbirth;
    private final LocalDate enrollmentDate;

    private Boolean graduated;

    public Student(String firstName, String lastName, String email, String dateofbirthStr, LocalDate enrollmentDate, Boolean graduated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateofbirth = LocalDate.parse(dateofbirthStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.enrollmentDate = enrollmentDate;
        this.graduated = false;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public LocalDate getDateOfBirth() {
        return dateofbirth;
    }
}
