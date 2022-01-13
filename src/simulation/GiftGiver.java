package simulation;

import children.Child;
import data.SimulationData;
import enums.Category;
import gifts.Gift;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GiftGiver {
    /**
     * Method that gives gifts to children base on assigned budgets
     */
    public void giveGiftsToChildren() {
        SimulationData simulationData = SimulationData.getInstance();

        // assign gifts to each child:
        for (Child child : simulationData.getChildren()) {
            List<Gift> childGiftList = new ArrayList<>();
            Double childBudget = child.getAssignedBudget();
            List<Category> preferences = child.getPreferences();

            // for each of the child's preferences, try to find a gift:
            for (Category preference : preferences) {
                // get a list of the gifts of preference category and sort
                // in ascending order:
                List<Gift> santaGifts = simulationData.getSanta().getSantaGiftsList();
                List<Gift> sortedGiftList = santaGifts.stream()
                        .filter(gift -> gift.getCategory() == preference)
                        .sorted(Comparator.comparingDouble(Gift::getPrice))
                        .collect(Collectors.toList());
                // give Gift to child if available:
                if (sortedGiftList.size() > 0) {
                    Gift givenGift = sortedGiftList.get(0);
                    if (givenGift.getPrice() <= childBudget) {
                        childGiftList.add(givenGift);
                        childBudget -= givenGift.getPrice();
                    }
                }
            }
            child.setReceivedGifts(childGiftList);
        }
    }
}
