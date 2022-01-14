package simulation.giftgiving;

import children.Child;
import data.SimulationData;
import enums.Category;
import enums.ElvesType;
import enums.GiftStrategy;
import utils.GiftPair;

import java.util.Comparator;

public class GiftGiver {
    /**
     * Method that gives gifts to children base on assigned budgets
     */
    public void giveGiftsToChildren(final GiftStrategy strategyToUse) {
        GiftGivingStrategy giftGivingStrategy = switch (strategyToUse) {
            case ID -> new GiftIdStrategy();
            case NICE_SCORE -> new GiftNiceScoreStrategy();
            case NICE_SCORE_CITY -> new GiftNiceScoreCityStrategy();
        };
        // assign gifts to children according to strategy:
        giftGivingStrategy.giveGifts();
        // apply the yellow elf's bonus:
        applyYellowElf();
    }

    private void applyYellowElf() {
        SimulationData simulationData = SimulationData.getInstance();
        for (Child child : simulationData.getChildren()) {
            if (child.getElf() == ElvesType.YELLOW
                && child.getReceivedGifts().size() == 0) {
                Category firstPreference = child.getPreferences().get(0);
                GiftPair giftPair = simulationData.getSanta().getSantaGiftsList().stream()
                        .filter(giftPair1 -> giftPair1.getGift().getCategory() == firstPreference)
                        .sorted(Comparator.comparingDouble(GiftPair::getPrice))
                        .findFirst().orElse(null);
                if (giftPair != null) {
                    if (giftPair.getQuantity() > 0) {
                        child.getReceivedGifts().add(giftPair.getGift());
                        giftPair.setQuantity(giftPair.getQuantity() - 1);
                    }
                }
            }
        }
    }
}
