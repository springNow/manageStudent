public class Subject {
    private String subjectId;
    private String subjectName;
    private String subjectType;

    int[] scores = new int[3];

    public Subject(String seq, String subjectName, String subjectType) {
        this.subjectId = seq;
        this.subjectName = subjectName;
        this.subjectType = subjectType;

        for(int i=0; i< scores.length; i++){
            scores[i] = -1;
        }
    }

    public void printScores(){

        System.out.println(subjectName+"의 점수는 다음과 같습니다.");
        for(int score : scores){
            System.out.println(score);
        }
    }

    public void printScoresAndGrades(){

        System.out.println(subjectName+"의 점수와 등급은 다음과 같습니다. ");
        if(subjectType.equalsIgnoreCase("MANDATORY")) {
            for (int i = 0; i < scores.length; i++) {
                if (scores[i] <= 100 && scores[i] >= 95) {
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "A등급");
                } else if (scores[i] <= 94 && scores[i] >= 90) {
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "B등급");
                } else if (scores[i] <= 89 && scores[i] >= 80) {
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "C등급");
                } else if (scores[i] <= 79 && scores[i] >= 70) {
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "D등급");
                } else if (scores[i] >= 0) {
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "F등급");
                } else
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "미응시");
            }
        }else{
            for (int i = 0; i < scores.length; i++) {
                if (scores[i] <= 100 && scores[i] >= 90) {
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "A등급");
                } else if (scores[i] <= 89 && scores[i] >= 80) {
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "B등급");
                } else if (scores[i] <= 79 && scores[i] >= 70) {
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "C등급");
                } else if (scores[i] <= 69 && scores[i] >= 60) {
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "D등급");
                } else if (scores[i] >= 0) {
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "F등급");
                } else
                    System.out.println(i + "회차\t|" + scores[i] + "점\t|" + "미응시");
            }
        }
    }

    public int[] getScores() {
        return scores;
    }

    // Getter
    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectType() {
        return subjectType;
    }

}
