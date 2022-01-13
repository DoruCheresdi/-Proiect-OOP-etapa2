package children;

import common.SimulationConstants;
import enums.Category;
import enums.ChildType;
import enums.Cities;
import enums.ElvesType;
import gifts.Gift;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private Integer id;
    private Integer age;
    private String lastName;
    private String firstName;
    private Cities city;
    private List<Double> niceScoreHistory;
    private Double averageScore;
    private Double assignedBudget;
    private List<Category> preferences;
    private List<Gift> receivedGifts;
    private Double niceScoreBonus;
    private ElvesType elf;

    public Child(final Integer id, final Integer age, final String lastName,
                 final String firstName, final Cities city,
                 final Double niceScore, final List<Category> preferences,
                 final Double niceScoreBonus, final ElvesType elf) {
        this.id = id;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        niceScoreHistory = new ArrayList<>();
        niceScoreHistory.add(niceScore);
        this.preferences = preferences;
        this.niceScoreBonus = niceScoreBonus;
        this.elf = elf;
    }

    /**
     * Method to determine type of child
     * @return
     */
    public ChildType determineType() {
        if (age < SimulationConstants.BEGGINING_AGE_KID) {
            return ChildType.BABY;
        }
        if (age >= SimulationConstants.BEGGINING_AGE_TEEN) {
            return ChildType.TEEN;
        }
        return ChildType.KID;
    }

    /**
     * Method that determines if a child is and adult
     * @return
     */
    public boolean isAdult() {
        return age > SimulationConstants.LAST_AGE_CHILDREN;
    }

    /**
     * Method to determine if a child has a certain preference
     * @param preference
     * @return
     */
    public boolean hasPreference(final Category preference) {
        return preferences.contains(preference);
    }

    /**
     * getter
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter
     * @param id
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * getter
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     * setter
     * @param age
     */
    public void setAge(final Integer age) {
        this.age = age;
    }

    /**
     * getter
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter
     * @param lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter
     * @param firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter
     * @return
     */
    public Cities getCity() {
        return city;
    }

    /**
     * setter
     * @param city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * getter
     * @return
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * setter
     * @param niceScoreHistory
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * getter
     * @return
     */
    public Double getAverageScore() {
        return averageScore;
    }

    /**
     * setter
     * @param averageScore
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * getter
     * @return
     */
    public Double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * setter
     * @param assignedBudget
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * getter
     * @return
     */
    public List<Category> getPreferences() {
        return preferences;
    }

    /**
     * setter
     * @param preferences
     */
    public void setPreferences(final List<Category> preferences) {
        this.preferences = preferences;
    }

    /**
     * getter
     * @return
     */
    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * setter
     * @param receivedGifts
     */
    public void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    /**
     * getter
     * @return
     */
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * setter
     * @param niceScoreBonus
     */
    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    /**
     * getter
     * @return
     */
    public ElvesType getElf() {
        return elf;
    }

    /**
     * setter
     * @param elf
     */
    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }
}
