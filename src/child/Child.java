package child;

import santa.SantaClaus;

import java.util.ArrayList;

public class Child {
    /**
     * Value of child's ID
     */
    private final Integer id;
    /**
     * Child's last name
     */
    private final String lastName;
    /**
     * Child's first name
     */
    private final String firstName;
    /**
     * Child's age
     */
    private Integer age;
    /**
     * Child's city
     */
    private final String city;
    /**
     * Child's nice score (last given)
     */
    private Double niceScore;
    /**
     * Child's gifts preferences
     */
    private ArrayList<String> giftsPreferences;
    /**
     * Child's average score
     */
    private Double niceScoreCalculated;
    /**
     * Child's budget for presents
     */
    private Double childBudget;
    /**
     * Child's score history
     */
    private ArrayList<Double> niceScoreHistory = new ArrayList<>();
    /**
     * Child's bonus score
     */
    private Integer niceScoreBonus;
    /**
     * Child's assigned elf
     */
    private String elf;
    // Class constructor
    public Child(final Integer id, final String lastName, final String firstName,
                 final Integer age, final String city, final Double niceScore,
                 final Integer niceScoreBonus, final ArrayList<String> giftsPreferences,
                 final String elf) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.niceScoreBonus = niceScoreBonus;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
    }

    /**
     * Method that returns value of child's ID
     */
    public Integer getId() {
        return id;
    }
    /**
     * Method that returns child's last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Method that returns child's first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Method that returns child's age
     */
    public Integer getAge() {
        return age;
    }
    /**
     * Method that returns child's city
     */
    public String getCity() {
        return city;
    }
    /**
     * Method that returns child's nice score (last given)
     */
    public  Double getNiceScore() {
        return niceScore;
    }
    /**
     * Method that returns child's gifts preferences
     */
    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }
    /**
     * Method that returns child's average score
     */
    public Double getNiceScoreCalculated() {
        return niceScoreCalculated;
    }
    /**
     * Method that returns child's budget for presents
     */
    public Double getChildBudget() {
        return childBudget;
    }
    /**
     * Method that returns child's score history
     */
    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * Method that sets child's new score (last given)
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }
    /**
     * Method that sets child's age
     */
    public void setAge(final Integer age) {
        this.age = age;
    }
    /**
     * Method that sets child's gifts preferences
     */
    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
    /**
     * Method that sets child's average score
     */
    public void setNiceScoreCalculated(final Double niceScoreCalculated) {
        this.niceScoreCalculated = niceScoreCalculated;
    }
    /**
     * Method that sets child's average score
     */
    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }
    /**
     * Method that calculate child's budget for presents
     */
    public void calculateChildBudget(final SantaClaus santaClaus) {
        this.childBudget = santaClaus.getBudgetUnit() * niceScoreCalculated;
    }
    /**
     * Method that sets child's budget
     */
    public void setChildBudget(final Double childBudget) {
        this.childBudget = childBudget;
    }
    /**
     * Method that returns child's bonus score
     */
    public Integer getNiceScoreBonus() {
        return niceScoreBonus;
    }
    /**
     * Method that sets child's bonus score
     */
    public void setNiceScoreBonus(final Integer niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    /**
     * Method that adds a new score to the score history
     */
    public void addToHistory(final Double newNiceScoreCalculated) {
        this.niceScoreHistory.add(newNiceScoreCalculated);
    }
    /**
     * Method that returns child's elf
     */
    public String getElf() {
        return elf;
    }
    /**
     * Method that sets child's elf
     */
    public void setElf(final String elf) {
        this.elf = elf;
    }
}
