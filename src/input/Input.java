package input;

import changes.AnnualChange;

import java.util.List;

public class Input {
    /**
     * Number of years that santa gives presents
     */
    private Integer numberOfYears;
    /**
     * Santa's initial budget
     */
    private Double santaBudget;
    /**
     * Santa's initial children
     */
    private final List<ChildInput> children;
    /**
     * Santa's initial gifts
     */
    private final List<GiftInput> gifts;
    /**
     * Santa's annual changes
     */
    private final List<AnnualChange> annualChanges;

    public Input() {
        this.numberOfYears = 0;
        this.santaBudget = 0.0;
        this.children = null;
        this.gifts = null;
        this.annualChanges = null;
    }

    public Input(final Integer numberOfYears, final Double santaBudget,
                 final List<ChildInput> children, final List<GiftInput> gifts,
                 final List<AnnualChange> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.children = children;
        this.gifts = gifts;
        this.annualChanges = annualChanges;
    }

    /**
     * Method that returns number of years that santa gives presents
     */
    public Integer getNumberOfYears() {
        return numberOfYears;
    }
    /**
     * Method that returns value of santa's initial budget
     */
    public Double getSantaBudget() {
        return santaBudget;
    }
    /**
     * Method that returns list of initial children
     */
    public List<ChildInput> getChildren() {
        return children;
    }
    /**
     * Method that returns list of initial gifts
     */
    public List<GiftInput> getGifts() {
        return gifts;
    }
    /**
     * Method that returns list of annual changes
     */
    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }
    /**
     * Method that sets number of years that santa gives presents
     */
    public void setNumberOfYears(final Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    /**
     * Method that sets value of santa's initial budget
     */
    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }
}
