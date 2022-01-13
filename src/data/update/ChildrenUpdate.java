package data.update;

import enums.Category;

import java.util.List;

public class ChildrenUpdate {
    private Integer id;
    private Double niceScore;
    private List<Category> giftPreferences;

    public ChildrenUpdate(final Integer id, final Double niceScore,
                          final List<Category> giftPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftPreferences = giftPreferences;
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
}
