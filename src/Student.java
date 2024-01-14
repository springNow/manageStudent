package manageStudent.src;

import java.util.List;

public class Student {

    private String studentId;
    private String studentName;
    List<Subject> subjectStudentPick;

    public Student(String seq,String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
    }

    public Student(String seq, String studentName, List<Subject> subjectStudentPick){
        this.studentId = seq;
        this.studentName = studentName;
        this.subjectStudentPick = subjectStudentPick;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSubjectStudentPick() {
        String a = "";
        for (Subject su: subjectStudentPick){
            a = a + su.getSubjectName() + "\n";
        }
        return a;
    }
}
