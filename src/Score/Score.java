package Score;

import Subject.Subject;

public class Score extends Subject {
    private String scoreId;
    private String scoreGrade;
    private int examScore;
    private String subjectName;
    private String subjectType;

    public Score() {
    }

    public Score(String seq) {
        super();
        this.scoreId = seq;
    }

    public Score(String seq, int examScore) {
        this.scoreId = seq;
        this.examScore = examScore;
    }

    public Score(String seq, int examScore, String subjectName, String scoreGrade) {
        super(subjectName);
        this.scoreId = seq;
        this.examScore = examScore;
        this.scoreGrade = scoreGrade;
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }

    public int getExamScore() {
        return examScore;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    public void setExamGrade(String scoreGrade) {
        this.scoreGrade = scoreGrade;
    }

    public String toString() {
        return "수험번호" + getScoreId() + " | " + "시험과목" + getSubjectName() + "시험점수" + getExamScore() + "등급" + getScoreGrade();
    }

    public String getScoreGrade() {
        return scoreGrade;
    }

}

// 상속을 잘못사용하고있다
// 사과 < 과일 (o) 과일 < 사과 (x)
