package simulation;

import children.Child;
import common.SimulationConstants;
import data.SimulationData;
import data.update.AnnualChange;
import data.update.ChildrenUpdate;
import enums.Category;
import enums.GiftStrategy;
import gifts.Gift;
import utils.GiftPair;

import java.util.ArrayList;
import java.util.List;

public class SimulationUpdater {
    /**
     * Method to update and add data to database
     * @param year
     */
    public GiftStrategy updateSimulation(final int year) {
        // add new data to database:
        // the index in the annualChangesList:
        int index = year - 1;

        SimulationData simulationData = SimulationData.getInstance();

        // update ages for children and remove adults:
        List<Child> childrenToRemove = new ArrayList<>();
        for (Child child : simulationData.getChildren()) {
            Integer age = child.getAge();
            if (age == SimulationConstants.LAST_AGE_CHILDREN) {
                childrenToRemove.add(child);
            } else {
                child.setAge(age + 1);
            }
        }
        simulationData.getChildren().removeAll(childrenToRemove);

        AnnualChange annualChange = simulationData.getAnnualChangeList().get(index);

        // add new children
        for (Child newChild : annualChange.getNewChildren()) {
            if (!newChild.isAdult()) {
                simulationData.getChildren().add(newChild);
            }
        }

        // update children:
        updateChildren(annualChange.getChildrenUpdates());

        // add new gifts:
        for (GiftPair newGift : annualChange.getNewGifts()) {
            simulationData.getSanta().getSantaGiftsList().add(newGift);
        }


        // change budget for this year:
        simulationData.getSanta().setSantaBudget(annualChange.getNewSantaBudget());

        return annualChange.getStrategy();
    }

    private void updateChildren(final List<ChildrenUpdate> childrenUpdateList) {
        for (ChildrenUpdate childrenUpdate : childrenUpdateList) {
            Integer id = childrenUpdate.getId();
            Child childToUpdate = findChildById(id);
            if (childToUpdate != null) {
                // if child is found:
                // add new nice score to nice score history:
                Double newNiceScore = childrenUpdate.getNiceScore();
                if (newNiceScore != null) {
                    childToUpdate.getNiceScoreHistory()
                            .add(newNiceScore);
                }

                // update elf:
                childToUpdate.setElf(childrenUpdate.getElf());

                // make each preference element in the update list unique:
                ArrayList<Integer> elementsToRemove = new ArrayList<Integer>();
                List<Category> prefUpdate = childrenUpdate.getGiftPreferences();
                for (int i = prefUpdate.size() - 1; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        if (prefUpdate.get(j) == prefUpdate.get(i)) {
                            elementsToRemove.add(i);
                            break;
                        }
                    }
                }
                // remove duplicates:
                for (int i = 0; i < elementsToRemove.size(); i++) {
                    childrenUpdate.getGiftPreferences().remove((int) elementsToRemove.get(i));
                }

                // add new preferences:
                int indexOfLastPreference = 0;
                for (Category category : childrenUpdate.getGiftPreferences()) {
                    if (childToUpdate.hasPreference(category)) {
                        childToUpdate.getPreferences().remove(category);
                    }
                    // new preferences are added in maintained order:
                    childToUpdate.getPreferences().add(indexOfLastPreference, category);
                    indexOfLastPreference++;
                }
            }
        }
    }

    private Child findChildById(final Integer id) {
        SimulationData simulationData = SimulationData.getInstance();
        List<Child> childList = simulationData.getChildren();
        for (Child child : childList) {
            if (child.getId().equals(id)) {
                return child;
            }
        }
        return null;
    }
}
