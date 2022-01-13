package simulation.scorestrategy;

import children.Child;
import common.SimulationConstants;

public class BabyStrategy implements NiceScoreStrategy {
    /**
     * Method to calculate average nice Score for baby
     * @param child
     */
    @Override
    public void calculateScore(final Child child) {
        child.setAverageScore(SimulationConstants.BABY_SCORE);
    }
}
