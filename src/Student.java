import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    List<Subject> subjectList;
    public Student(){}
    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
    }

    public Student(String seq, String studentName, List<Subject> subjectList) {
        this.studentId = seq;
        this.studentName = studentName;
        this.subjectList = subjectList;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
    public List<Subject> getSubjectList(){
        return subjectList;
    }

}
