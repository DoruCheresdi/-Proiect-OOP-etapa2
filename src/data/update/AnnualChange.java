package data.update;

import children.Child;
import enums.GiftStrategy;
import gifts.Gift;
import utils.GiftPair;

import java.util.List;

public class AnnualChange {
    private Double newSantaBudget;
    private List<GiftPair> newGifts;
    private List<Child> newChildren;
    private List<ChildrenUpdate> childrenUpdates;
    private GiftStrategy strategy;

    public AnnualChange(final Double newSantaBudget, final List<GiftPair> newGifts,
                        final List<Child> newChildren,
                        final List<ChildrenUpdate> childrenUpdates,
                        final GiftStrategy strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategy = strategy;
    }

    /**
     * getter
     * @return
     */
    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     * setter
     * @param newSantaBudget
     */
    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    /**
     * getter
     * @return
     */
    public List<GiftPair> getNewGifts() {
        return newGifts;
    }

    /**
     * setter
     * @param newGifts
     */
    public void setNewGifts(final List<GiftPair> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     * getter
     * @return
     */
    public List<Child> getNewChildren() {
        return newChildren;
    }

    /**
     * setter
     * @param newChildren
     */
    public void setNewChildren(final List<Child> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     * getter
     * @return
     */
    public List<ChildrenUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     * setter
     * @param childrenUpdates
     */
    public void setChildrenUpdates(final List<ChildrenUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    /**
     * getter
     * @return
     */
    public GiftStrategy getStrategy() {
        return strategy;
    }

    /**
     * setter
     * @param strategy
     */
    public void setStrategy(final GiftStrategy strategy) {
        this.strategy = strategy;
    }
}
