package data;

import children.Child;
import data.update.AnnualChange;
import santa.Santa;

import java.util.List;

public class SimulationData {
    private static SimulationData simulationData;
    private int numberOfYears;
    private List<AnnualChange> annualChangeList;
    private List<Child> children;
    private Santa santa;


    /**
     * Method to return instance
     * @return the unique instance of the class
     */
    public static SimulationData getInstance() {
        if (simulationData == null) {
            simulationData = new SimulationData();
            return simulationData;
        }
        return simulationData;
    }

    /**
     * function to empty data from previous tests
     */
    public void emptyData() {
        simulationData = new SimulationData();
    }

    /**
     * getter
     * @return
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * setter
     * @param numberOfYears
     */
    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * getter
     * @return
     */
    public List<AnnualChange> getAnnualChangeList() {
        return annualChangeList;
    }

    /**
     * setter
     * @param annualChangeList
     */
    public void setAnnualChangeList(final List<AnnualChange> annualChangeList) {
        this.annualChangeList = annualChangeList;
    }

    /**
     * getter
     * @return
     */
    public List<Child> getChildren() {
        return children;
    }

    /**
     * setter
     * @param children
     */
    public void setChildren(final List<Child> children) {
        this.children = children;
    }

    /**
     * getter
     * @return
     */
    public Santa getSanta() {
        return santa;
    }

    /**
     * setter
     * @param santa
     */
    public void setSanta(final Santa santa) {
        this.santa = santa;
    }
}
