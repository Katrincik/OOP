package Lab2;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final String name;
    private final String abbreviation;
    private final List<Student> students;
    private final StudyField studyField;

    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void graduateStudent(Student student) {
        students.remove(student);
    }
}

