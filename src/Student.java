package manageStudent.src;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    List<Subject> studentInfoArray;
    public Student(){}

    public Student(String seq){
        this.studentId = seq;
    }
    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
    }

    public Student(String seq, String studentName, List<Subject> studentInfoArray) {
        this.studentId = seq;
        this.studentName = studentName;
        this.studentInfoArray = studentInfoArray;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }


    public List<Subject> getStudentInfoArray(){
        return studentInfoArray;
    }
}
