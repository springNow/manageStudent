package manageStudent.src;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.List;
import java.util.Map;

public class Score{
    //회차
    private String scoreId;

    Map<String, List<Subject>> studentNoSubjectArr;
    //점수 넣는 리스트
//    List<Score> scoreWhat;
    //subjectList, int 넣어야함.
    List<String> scoreList;


    public Score(String seq, int score) {
        this.scoreId = seq;
        this.scoreList = scoreList;
    }
    public Score(String seq) {
        this.scoreId = seq;
    }

    public Score(Map<String, List<Subject>> studentNoSubjectArr, List<String> scoreList) {
        this.studentNoSubjectArr = studentNoSubjectArr;
        this.scoreList = scoreList;
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }

    public List<String> getScoreList() {
        return scoreList;
    }
    public Map<String, List<Subject>> getStudentNoSubjectArr() {
        return studentNoSubjectArr;
    }
    public List<String> scoreList() {
        return scoreList;
    }

    public String toString() {
        return "   " +  this.getStudentNoSubjectArr() + "\n" + this.scoreList();
    }
}
