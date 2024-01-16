import java.util.List;

public class Student {
    private int studentId;
    private String studentName;
    List<Subject> subjects;
    List<Score> scores;
    public Student(int seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", subjects=" + subjects.toString() +
                ", scores=" + scores.toString() +
                '}';
    }

    public Student(int studentId, String studentName, List<Subject> subjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.subjects = subjects;
    }

    public Student(int studentId, String studentName, List<Subject> subjects, List<Score> scores) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.subjects = subjects;
        this.scores = scores;
    }

    public Student(int studentId, List<Subject> subjects, List<Score> scores) {
        this.studentId = studentId;
        this.subjects = subjects;
        this.scores = scores;
    }

    public Student(int studentId, List<Score> scores) {
        this.studentId = studentId;
        this.scores = scores;
    }

    // Getter
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Score> getScores() {
        return scores;
    }
}
