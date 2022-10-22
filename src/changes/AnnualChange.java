package changes;

import input.ChildInput;
import input.GiftInput;

import java.util.List;

public class AnnualChange {
    /**
     * Value of Santa's new budget
     */
    private Double newSantaBudget;
    /**
     * List with santa's new gifts
     */
    private List<GiftInput> newGifts;
    /**
     * List with santa's new children
     */
    private List<ChildInput> newChildren;
    /**
     * List with children that need to be updated
     */
    private List<ChildUpdate> childrenUpdate;
    /**
     * String that contains the strategy
     */
    private String strategy;

    public AnnualChange(final Double newSantaBudget,
                        final List<GiftInput> newGifts,
                        final List<ChildInput> newChildren,
                        final List<ChildUpdate> childrenUpdate,
                        final String strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdate = childrenUpdate;
        this.strategy = strategy;
    }

    /**
     * Method that returns santa's new budget
     */
    public Double getNewSantaBudget() {
        return newSantaBudget;
    }
    /**
     * Method that sets santa's new budget
     */
    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }
    /**
     * Method that returns santa's list of new gifts
     */
    public List<GiftInput> getNewGifts() {
        return newGifts;
    }
    /**
     * Method that sets santa's new gifts
     */
    public void setNewGifts(final List<GiftInput> newGifts) {
        this.newGifts = newGifts;
    }
    /**
     * Method that returns santa's list of new children
     */
    public List<ChildInput> getNewChildren() {
        return newChildren;
    }
    /**
     * Method that sets santa's list of new children
     */
    public void setNewChildren(final List<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }
    /**
     * Method that returns santa's list of children that need to be updated
     */
    public List<ChildUpdate> getChildrenUpdate() {
        return childrenUpdate;
    }
    /**
     * Method that sets santa's list of children that need to be updated
     */
    public void setChildrenUpdate(final List<ChildUpdate> childrenUpdate) {
        this.childrenUpdate = childrenUpdate;
    }
    /**
     * Method that returns the strategy
     */
    public String getStrategy() {
        return strategy;
    }
    /**
     * Method that sets the strategy
     */
    public void setStrategy(final String strategy) {
        this.strategy = strategy;
    }
}
