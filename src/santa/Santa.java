package santa;

import gifts.Gift;

import java.util.List;

public class Santa {
    private Double santaBudget;
    private List<Gift> santaGiftsList;

    public Santa(final Double santaBudget, final List<Gift> santaGiftsList) {
        this.santaBudget = santaBudget;
        this.santaGiftsList = santaGiftsList;
    }

    /**
     * getter
     * @return
     */
    public Double getSantaBudget() {
        return santaBudget;
    }

    /**
     * setter
     * @param santaBudget
     */
    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     * getter
     * @return
     */
    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     * setter
     * @param santaGiftsList
     */
    public void setSantaGiftsList(final List<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
