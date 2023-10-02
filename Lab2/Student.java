package Lab2;

import java.time.LocalDate;

public class Student {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final LocalDate enrollmentDate;
    private final LocalDate dateofbirth;

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
