package simulation.giftgiving;

import children.Child;
import data.SimulationData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GiftIdStrategy implements GiftGivingStrategy {
    /**
     * Method to give gifts to children
     */
    @Override
    public void giveGifts() {
        SimulationData simulationData = SimulationData.getInstance();
        List<Child> childList = simulationData.getChildren();
        List<Child> sortedChildList = childList.stream()
                .sorted(Comparator.comparingInt(Child::getId))
                .collect(Collectors.toList());

        // assign gifts to each child:
        GiftGiver.giveGiftsToChildren(sortedChildList);
    }
}
