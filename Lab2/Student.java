package Lab2;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate enrollmentDate;
    private LocalDate dateofbirth;

    public Student(String firstName,String lastName, String email, LocalDate enrollmentDate, LocalDate dateofbirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }
}
