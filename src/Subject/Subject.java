package Subject;

public class Subject {
    private String subjectId;
    private String subjectName;
    private String subjectType;

    public Subject(String seq, String subjectName, String subjectType) {
        this.subjectId = seq;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    // Getter
    public Subject() {
    }


    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public String toString() {
        return "과목코드 : " + subjectId + " | " + "과목이름 : " + subjectName + " | " + "필수유무 : " + subjectType;
    }

}
