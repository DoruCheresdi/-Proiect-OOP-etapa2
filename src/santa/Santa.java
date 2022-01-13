package santa;

import gifts.Gift;
import utils.GiftPair;

import java.util.List;

public class Santa {
    private Double santaBudget;
    private List<GiftPair> santaGiftsList;

    public Santa(final Double santaBudget, final List<GiftPair> santaGiftsList) {
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
    public List<GiftPair> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     * setter
     * @param santaGiftsList
     */
    public void setSantaGiftsList(final List<GiftPair> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
