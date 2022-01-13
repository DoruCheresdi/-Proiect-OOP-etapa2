package simulation;

import children.Child;
import data.SimulationData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BudgetCalculator {
    /**
     * Method that calculates each child's assigned budget
     */
    public void calculateBudget() {
        SimulationData simulationData = SimulationData.getInstance();
        // calculate total sum of average niceScores:
        Double niceScoresSum = 0d;
        List<Child> childList = simulationData.getChildren();

        List<Child> orderedList = new ArrayList<>(childList);
        orderedList.sort(Comparator.comparingInt(Child::getId));

        for (Child child : orderedList) {
            niceScoresSum += child.getAverageScore();
        }

        // calculate budget unit:
        Double santaBudget = simulationData.getSanta().getSantaBudget();
        Double budgetUnit = santaBudget / niceScoresSum;

        // calculate the assigned budget for each child:
        for (Child child : simulationData.getChildren()) {
            Double niceScoreChild = child.getAverageScore();
            child.setAssignedBudget(budgetUnit * niceScoreChild);
        }
    }
}
