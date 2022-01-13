package data.update;

import enums.Category;
import enums.ElvesType;

import java.util.List;

public class ChildrenUpdate {
    private Integer id;
    private Double niceScore;
    private List<Category> giftPreferences;
    private ElvesType elf;

    public ChildrenUpdate(final Integer id, final Double niceScore,
                          final List<Category> giftPreferences,
                          final ElvesType elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftPreferences = giftPreferences;
        this.elf = elf;
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
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * setter
     * @param niceScore
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * getter
     * @return
     */
    public List<Category> getGiftPreferences() {
        return giftPreferences;
    }

    /**
     * setter
     * @param giftPreferences
     */
    public void setGiftPreferences(final List<Category> giftPreferences) {
        this.giftPreferences = giftPreferences;
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
