package data.update;

import children.Child;
import gifts.Gift;

import java.util.List;

public class AnnualChange {
    private Double newSantaBudget;
    private List<Gift> newGifts;
    private List<Child> newChildren;
    private List<ChildrenUpdate> childrenUpdates;

    public AnnualChange(final Double newSantaBudget, final List<Gift> newGifts,
                        final List<Child> newChildren,
                        final List<ChildrenUpdate> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
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
    public List<Gift> getNewGifts() {
        return newGifts;
    }

    /**
     * setter
     * @param newGifts
     */
    public void setNewGifts(final List<Gift> newGifts) {
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
}
