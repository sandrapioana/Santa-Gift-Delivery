package santa;

import child.Child;
import gift.Gift;

import java.util.ArrayList;

public final class SantaClaus {
    /**
     * Santa's current budget
     */
    private Double santaBudget;
    /**
     * Santa's current budget unit
     */
    private Double budgetUnit;
    /**
     * Santa's current list of children
     */
    private ArrayList<Child> children;
    /**
     * Santa's current list of gifts
     */
    private ArrayList<Gift> gifts;
    /**
     * Singleton instance
     */
    private static SantaClaus santaClaus = null;
    /**
     * Private constructor for Singleton
     */
    private SantaClaus() {
    }
    /**
     * Method to get the same instance for Singleton
     */
    public static SantaClaus getSantaClaus() {
        if (santaClaus == null) {
            santaClaus = new SantaClaus();
        }
        return santaClaus;
    }
    /**
     * Method that returns santa's current budget
     */
    public Double getSantaBudget() {
        return santaBudget;
    }
    /**
     * Method that returns santa's current budget unit
     */
    public Double getBudgetUnit() {
        return budgetUnit;
    }
    /**
     * Method that sets santa's current budget
     */
    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }
    /**
     * Method that sets santa's current budget unit
     */
    public void setBudgetUnit(final Double budgetUnit) {
        this.budgetUnit = budgetUnit;
    }
    /**
     * Method that returns santa's current list of children
     */
    public ArrayList<Child> getChildren() {
        return children;
    }
    /**
     * Method that sets santa's current list of children
     */
    public void setChildren(final ArrayList<Child> children) {
        this.children = children;
    }
    /**
     * Method that returns santa's current list of gifts
     */
    public ArrayList<Gift> getGifts() {
        return gifts;
    }
    /**
     * Method that sets santa's current list of gifts
     */
    public void setGifts(final ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }

}
