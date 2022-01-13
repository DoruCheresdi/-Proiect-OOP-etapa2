package simulation.scorestrategy;

import children.Child;

import java.util.List;

public class TeenStrategy implements NiceScoreStrategy {
    /**
     * Method to calculate average nice Score for teen
     * @param child
     */
    @Override
    public void calculateScore(final Child child) {
        List<Double> scoreHistory = child.getNiceScoreHistory();

        // calculate average:
        Double sum = 0d;
        for (int i = 0; i < scoreHistory.size(); i++) {
            sum += scoreHistory.get(i) * (i + 1);
        }
        int size = scoreHistory.size();
        Double averageScore = sum / (size * (size + 1) / 2);

        child.setAverageScore(averageScore);
    }
}
