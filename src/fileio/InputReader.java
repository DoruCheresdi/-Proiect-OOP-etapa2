package fileio;

import children.Child;
import common.SimulationConstants;
import data.SimulationData;
import data.update.AnnualChange;
import data.update.ChildrenUpdate;
import enums.Category;
import enums.Cities;
import gifts.Gift;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import santa.Santa;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    private final String inputPath;

    public InputReader(final String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * function to read data for a test
     */
    public void readData() {
        JSONParser jsonParser = new JSONParser();
        SimulationData simulationData = SimulationData.getInstance();

        // data to be read:
        int numberOfYears = 0;
        List<AnnualChange> annualChangeList = new ArrayList<>();
        List<Child> children = new ArrayList<>();
        List<Gift> gifts = new ArrayList<>();
        Double santaBudget = 0d;
        Santa santa;

        try {
            JSONObject jsonObject = (JSONObject) jsonParser
                    .parse(new FileReader(inputPath));

            numberOfYears = ((Long) jsonObject.get(SimulationConstants.NUMBER_OF_YEARS))
                    .intValue();
            santaBudget = ((Number) jsonObject.get(SimulationConstants.SANTA_BUDGET))
                    .doubleValue();
            JSONObject initialData = (JSONObject) jsonObject
                    .get(SimulationConstants.INITIAL_DATA);
            JSONArray childrenJson = (JSONArray) initialData
                    .get(SimulationConstants.CHILDREN);
            JSONArray giftsJson = (JSONArray) initialData
                    .get(SimulationConstants.SANTA_GIFTS_LIST);
            JSONArray annualChangesJson = (JSONArray) jsonObject
                    .get(SimulationConstants.ANNUAL_CHANGES);

            // parse the children json:
            if (childrenJson != null) {
                parseChildrenList(children, childrenJson);
            }

            // parse the gifts json:
            if (giftsJson != null) {
                for (Object giftJson : giftsJson) {
                    gifts.add(new Gift(
                            (String) ((JSONObject) giftJson)
                                    .get(SimulationConstants.PRODUCT_NAME),
                            ((Number) ((JSONObject) giftJson)
                                    .get(SimulationConstants.PRICE))
                                    .doubleValue(),
                            Category.categoryOfValue((String) ((JSONObject) giftJson)
                                    .get(SimulationConstants.CATEGORY))
                    ));
                }
            }
            annualChangeList = parseAnnualChange(annualChangesJson);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }


        // adding data to database:
        simulationData.setNumberOfYears(numberOfYears);
        simulationData.setAnnualChangeList(annualChangeList);
        simulationData.setChildren(children);
        santa = new Santa(santaBudget, gifts);
        simulationData.setSanta(santa);
    }

    private List<AnnualChange> parseAnnualChange(final JSONArray annualChangesJson) {
        List<AnnualChange> annualChangeList = new ArrayList<>();
        // parse the annual changes:
        for (Object changeJson : annualChangesJson) {
            Double newSantaBudget = ((Number) ((JSONObject) changeJson)
                    .get(SimulationConstants.NEW_SANTA_BUDGET))
                    .doubleValue();

            // parse new gifts:
            List<Gift> newGifts = new ArrayList<>();
            JSONArray newGiftsJSON = (JSONArray) ((JSONObject) changeJson)
                    .get(SimulationConstants.NEW_GIFTS);
            for (Object newGiftJson: newGiftsJSON) {
                newGifts.add(new Gift(
                        (String) ((JSONObject) newGiftJson)
                                .get(SimulationConstants.PRODUCT_NAME),
                        ((Number) ((JSONObject) newGiftJson)
                                .get(SimulationConstants.PRICE))
                                .doubleValue(),
                        Category.categoryOfValue((String) ((JSONObject) newGiftJson)
                                .get(SimulationConstants.CATEGORY))
                ));
            }

            // parse new children:
            List<Child> newChildren = new ArrayList<>();
            JSONArray newChildrenJson = (JSONArray) ((JSONObject) changeJson)
                    .get(SimulationConstants.NEW_CHILDREN);
            parseChildrenList(newChildren, newChildrenJson);

            // parse children updates:
            List<ChildrenUpdate> childrenUpdates = new ArrayList<>();
            JSONArray childrenUpdatesJson = (JSONArray) ((JSONObject) changeJson)
                    .get(SimulationConstants.CHILDREN_UPDATES);
            for (Object childUpdateJson: childrenUpdatesJson) {
                // parse new nice score, can be null:
                Number newNiceScoreNumber = ((Number) ((JSONObject) childUpdateJson)
                        .get(SimulationConstants.NICE_SCORE));
                Double newNiceScore;
                if (newNiceScoreNumber != null) {
                    newNiceScore = newNiceScoreNumber.doubleValue();
                } else {
                    newNiceScore = null;
                }

                // parse new preferences:
                JSONArray giftPreferencesJson =
                        (JSONArray) ((JSONObject) childUpdateJson)
                                .get(SimulationConstants.GIFT_PREFERENCES);
                List<Category> childPreferences = Utils.jsonToCategory(giftPreferencesJson);

                childrenUpdates.add(new ChildrenUpdate(
                        ((Long) ((JSONObject) childUpdateJson).get(SimulationConstants.ID))
                                .intValue(),
                        newNiceScore,
                        childPreferences
                ));
            }
            // add data to annual changes list:
            annualChangeList.add(new AnnualChange(
                    newSantaBudget,
                    newGifts,
                    newChildren,
                    childrenUpdates
            ));
        }
        return annualChangeList;
    }

    private void parseChildrenList(final List<Child> children, final JSONArray childrenJson) {
        for (Object childJson : childrenJson) {
            JSONArray giftPreferencesJson =
                    (JSONArray) ((JSONObject) childJson)
                            .get(SimulationConstants.GIFT_PREFERENCES);
            List<Category> childPreferences = Utils.jsonToCategory(giftPreferencesJson);

            children.add(new Child(
                    ((Long) ((JSONObject) childJson).get(SimulationConstants.ID))
                            .intValue(),
                    ((Long) ((JSONObject) childJson).get(SimulationConstants.AGE))
                            .intValue(),
                    (String) ((JSONObject) childJson).get(SimulationConstants.LAST_NAME),
                    (String) ((JSONObject) childJson).get(SimulationConstants.FIRST_NAME),
                    Cities.cityOfValue((String) ((JSONObject) childJson)
                            .get(SimulationConstants.CITY)),
                    ((Number) ((JSONObject) childJson)
                            .get(SimulationConstants.NICE_SCORE))
                            .doubleValue(),
                    childPreferences
            ));
        }
    }
}
