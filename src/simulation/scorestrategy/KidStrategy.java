package simulation.scorestrategy;

import children.Child;

import java.util.List;

public class KidStrategy implements NiceScoreStrategy {
    /**
     * Method to calculate average nice Score for kid
     * @param child
     */
    @Override
    public void calculateScore(final Child child) {
        List<Double> scoreHistory = child.getNiceScoreHistory();

        // calculate average:
        Double sum = 0d;
        for (Double score : scoreHistory) {
            sum += score;
        }
        Double averageScore = sum / scoreHistory.size();

        child.setAverageScore(averageScore);
    }
}
