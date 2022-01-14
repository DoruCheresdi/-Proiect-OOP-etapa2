package simulation.giftgiving;

import children.Child;
import data.SimulationData;
import enums.Category;
import enums.Cities;
import gifts.Gift;
import simulation.Simulation;
import utils.CityPair;
import utils.GiftPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GiftNiceScoreCityStrategy implements GiftGivingStrategy {
    @Override
    public void giveGifts() {
        SimulationData simulationData = SimulationData.getInstance();
        List<Cities> citiesList = new ArrayList<>(Arrays.asList(Cities.values()));
        List<CityPair> cityPairList = new ArrayList<>();

        for (Cities city :
                citiesList) {
            List<Child> childList = simulationData.getChildren()
                    .stream().filter(child -> child.getCity() == city)
                    .sorted(Comparator.comparingDouble(Child::getId))
                    .collect(Collectors.toList());
            Double averageCityScore = 0d;
            for (Child child :
                    childList) {
                averageCityScore += child.getAverageScore();
            }
            averageCityScore = averageCityScore / childList.size();
            cityPairList.add(new CityPair(city, averageCityScore));
        }

        // sort first descending by averageNiceScore, then alphabetically:
        cityPairList.sort((pair1, pair2) -> {
            if (pair1.getAverageNiceScore() < pair2.getAverageNiceScore()) {
                return 1;
            } else if (pair1.getAverageNiceScore() > pair2.getAverageNiceScore()) {
                return -1;
            } else return pair1.getCity().getValue().compareTo(pair2.getCity().getValue());
        });

        for (CityPair cityPair :
                cityPairList) {
            Cities city = cityPair.getCity();
            List<Child> childList = simulationData.getChildren().stream()
                    .filter(child -> child.getCity() == city)
                    .sorted(Comparator.comparingInt(Child::getId)
                            .reversed())
                    .collect(Collectors.toList());

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
}
