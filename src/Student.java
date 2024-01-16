import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;

    private String status = "입력되지 않음";

    private List<Subject> subjects;

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
        subjects = new ArrayList<>();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

