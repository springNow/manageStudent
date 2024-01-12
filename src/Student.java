import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;

    private List<Subject> subjects;

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
        this.subjects = new ArrayList<>();
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> setListSubject) {
        this.subjects = setListSubject;
    }

    public void addSubject(Subject subject){
        this.subjects.add(subject);
    }
}
