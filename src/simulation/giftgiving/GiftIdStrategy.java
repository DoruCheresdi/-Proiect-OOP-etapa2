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

public class GiftIdStrategy implements GiftGivingStrategy {
    @Override
    public void giveGifts() {
        SimulationData simulationData = SimulationData.getInstance();
        List<Child> childList = simulationData.getChildren();
        List<Child> sortedChildList = childList.stream()
                .sorted(Comparator.comparingInt(Child::getId))
                .collect(Collectors.toList());

        // assign gifts to each child:
        for (Child child : sortedChildList) {
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
                if (sortedGiftList.size() > 0) {
                    GiftPair givenGiftPair = sortedGiftList.get(0);
                    if (givenGiftPair.getPrice() <= childBudget &&
                            givenGiftPair.getQuantity() > 0) {
                        childGiftList.add(givenGiftPair.getGift());

                        childBudget -= givenGiftPair.getPrice();
                        givenGiftPair.setQuantity(givenGiftPair.getQuantity() - 1);
                    }
                }
            }
            child.setReceivedGifts(childGiftList);
        }
    }
}
