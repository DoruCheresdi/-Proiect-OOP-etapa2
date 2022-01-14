package simulation.giftgiving;

import children.Child;
import data.SimulationData;
import enums.Category;
import gifts.Gift;
import utils.GiftPair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GiftGivingStrategy {
    /**
     * Method to give gifts to children
     */
    public void giveGifts() {

    }

    /**
     * Method to assign gifts to children in the childlist
     * in the order they were given
     * @param childList
     */
    protected void giveGiftsToChildren(final List<Child> childList) {
        SimulationData simulationData = SimulationData.getInstance();
        for (Child child : childList) {
            List<Gift> childGiftList = new ArrayList<>();
            Double childBudget = child.getAssignedBudget();
            List<Category> preferences = child.getPreferences();

            // for each of the child's preferences, try to find a gift:
            for (Category preference : preferences) {
                // get a list of the gifts of preference category and sort
                // in ascending order:
                List<GiftPair> santaGifts = simulationData.getSanta().getSantaGiftsList();
                List<GiftPair> sortedGiftList = santaGifts.stream()
                        .filter(giftPair -> giftPair.getGift().getCategory() == preference)
                        .sorted(Comparator.comparingDouble(GiftPair::getPrice))
                        .collect(Collectors.toList());
                // give Gift to child if available:
                int index = 0;
                boolean giftIsGiven = false;
                while (index < sortedGiftList.size() && !giftIsGiven) {
                    GiftPair givenGiftPair = sortedGiftList.get(index);
                    if (givenGiftPair.getPrice() <= childBudget
                            && givenGiftPair.getQuantity() > 0) {
                        childGiftList.add(givenGiftPair.getGift());

                        childBudget -= givenGiftPair.getPrice();
                        givenGiftPair.setQuantity(givenGiftPair.getQuantity() - 1);
                        giftIsGiven = true;
                    }
                    index++;
                }
            }
            child.setReceivedGifts(childGiftList);
        }
    }
}
