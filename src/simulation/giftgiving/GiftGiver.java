package simulation.giftgiving;

import children.Child;
import data.SimulationData;
import enums.Category;
import enums.ElvesType;
import enums.GiftStrategy;
import gifts.Gift;
import simulation.Simulation;
import utils.GiftPair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GiftGiver {
    /**
     * Method that gives gifts to children base on assigned budgets
     */
    public void giveGiftsToChildren(final GiftStrategy strategyToUse) {
        GiftGivingStrategy giftGivingStrategy;
        switch (strategyToUse) {
            case ID:
                giftGivingStrategy = new GiftIdStrategy();
                break;
            case NICE_SCORE:
                giftGivingStrategy = new GiftNiceScoreStrategy();
                break;
            case NICE_SCORE_CITY:
                giftGivingStrategy = new GiftNiceScoreCityStrategy();
                break;
            default: throw new IllegalArgumentException("unknown gift giving strategy");
        }
        giftGivingStrategy.giveGifts();
        applyYellowElf();
    }

    private void applyYellowElf() {
        SimulationData simulationData = SimulationData.getInstance();
        for (Child child :
                simulationData.getChildren()) {
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
