import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;

    private List<Subject> subjects;

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
        subjects = new ArrayList<>();
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

}

