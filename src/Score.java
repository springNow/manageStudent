
public class Score {
    private int score1;
    private int score2;
    private int score3;

    public Score(int score1, int score2, int score3) {
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    @Override
    public String toString() {
        return "Score{" +
                 score1 +
                ", " + score2 +
                ", " + score3 +
                '}';
    }
    // Getter


    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getScore3() {
        return score3;
    }
}
