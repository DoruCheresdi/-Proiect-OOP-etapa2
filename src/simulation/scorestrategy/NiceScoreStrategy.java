package simulation.scorestrategy;

import children.Child;

public interface NiceScoreStrategy {
    /**
     * Method to calculate average nice Score for child
     * @param child
     */
    void calculateScore(Child child);
}
