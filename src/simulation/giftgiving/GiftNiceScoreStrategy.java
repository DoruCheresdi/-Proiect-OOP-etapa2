package simulation.giftgiving;

import children.Child;
import data.SimulationData;

import java.util.List;
import java.util.stream.Collectors;

public class GiftNiceScoreStrategy implements GiftGivingStrategy {
    /**
     * Method to give gifts to children
     */
    @Override
    public void giveGifts() {
        SimulationData simulationData = SimulationData.getInstance();
        List<Child> childList = simulationData.getChildren();
        // sort desc by nice score, then asc by id:
        List<Child> sortedChildList = childList.stream()
                .sorted((child1, child2) -> {
                    if (child1.getAverageScore().compareTo(child2.getAverageScore()) == 0) {
                        return child1.getId() - child2.getId();
                    } else {
                        return child2.getAverageScore().compareTo(child1.getAverageScore());
                    }
                })
                .collect(Collectors.toList());

        // assign gifts to each child:
        GiftGiver.giveGiftsToChildren(sortedChildList);
    }
}
