package baithithuchanh;

public class Subject {
    private String name;
    private int[] scores;

    public Subject(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public int[] getScores() {
        return scores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append(", Scores: ");
        for (int score : scores) {
            sb.append(score).append(" ");
        }
        return sb.toString();
    }
}