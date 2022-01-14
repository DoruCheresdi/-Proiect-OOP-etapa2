package simulation.giftgiving;

import children.Child;
import data.SimulationData;
import enums.Cities;
import utils.CityPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GiftNiceScoreCityStrategy extends GiftGivingStrategy {
    /**
     * Method to give gifts to children
     */
    @Override
    public void giveGifts() {
        SimulationData simulationData = SimulationData.getInstance();
        List<Cities> citiesList = new ArrayList<>(Arrays.asList(Cities.values()));
        List<CityPair> cityPairList = new ArrayList<>();

        // make a list of pairs of all cities that have at least one child
        for (Cities city : citiesList) {
            List<Child> childList = simulationData.getChildren()
                    .stream().filter(child -> child.getCity() == city)
                    .sorted(Comparator.comparingInt(Child::getId))
                    .collect(Collectors.toList());
            if (childList.size() > 0) {
                Double averageCityScore = 0d;
                for (Child child : childList) {
                    averageCityScore += child.getAverageScore();
                }
                averageCityScore = averageCityScore / childList.size();
                cityPairList.add(new CityPair(city, averageCityScore));
            }
        }

        // sort first descending by averageNiceScore, then alphabetically:
        cityPairList.sort((pair1, pair2) -> {
            if (pair1.getAverageNiceScore() < pair2.getAverageNiceScore()) {
                return 1;
            } else if (pair1.getAverageNiceScore() > pair2.getAverageNiceScore()) {
                return -1;
            } else {
                return pair1.getCity().getValue().compareTo(pair2.getCity().getValue());
            }
        });

        for (CityPair cityPair : cityPairList) {
            Cities city = cityPair.getCity();
            List<Child> childList = simulationData.getChildren().stream()
                    .filter(child -> child.getCity() == city)
                    .sorted(Comparator.comparingInt(Child::getId))
                    .collect(Collectors.toList());

            giveGiftsToChildren(childList);
        }
    }


}
