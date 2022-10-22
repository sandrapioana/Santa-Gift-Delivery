package santa;

import java.util.ArrayList;

public class ChildOutput {
    /**
     * Value of output child's ID
     */
    private Integer id;
    /**
     * Output child's last name
     */
    private String lastName;
    /**
     * Output child's first name
     */
    private String firstName;
    /**
     * Output child's city
     */
    private String city;
    /**
     * Output child's age
     */
    private Integer age;
    /**
     * Output child's gifts preferences
     */
    private ArrayList<String> giftsPreferences;
    /**
     * Output child's average score
     */
    private Double averageScore;
    /**
     * Output child's score history
     */
    private ArrayList<Double> niceScoreHistory;
    /**
     * Output child's budget for presents
     */
    private Double assignedBudget;
    /**
     * List of output child's received gifts
     */
    private ArrayList<GiftOutput> receivedGifts;

    public ChildOutput(final Integer id, final String lastName, final String firstName,
                       final String city, final Integer age,
                       final ArrayList<String> giftsPreferences,
                       final Double averageScore, final ArrayList<Double> niceScoreHistory,
                       final Double assignedBudget, final ArrayList<GiftOutput> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = averageScore;
        this.niceScoreHistory = niceScoreHistory;
        this.assignedBudget = assignedBudget;
        this.receivedGifts = receivedGifts;
    }
    /**
     * Method that returns value of output child's ID
     */
    public Integer getId() {
        return id;
    }
    /**
     * Method that sets value of output child's ID
     */
    public void setId(final Integer id) {
        this.id = id;
    }
    /**
     * Method that returns output child's last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Method that sets output child's last name
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * Method that returns output child's first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Method that sets output child's first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * Method that returns output child's city
     */
    public String getCity() {
        return city;
    }
    /**
     * Method that returns output child's city
     */
    public void setCity(final String city) {
        this.city = city;
    }
    /**
     * Method that returns output child's age
     */
    public Integer getAge() {
        return age;
    }
    /**
     * Method that sets output child's age
     */
    public void setAge(final Integer age) {
        this.age = age;
    }
    /**
     * Method that returns output child's gifts preferences
     */
    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }
    /**
     * Method that sets output child's gifts preferences
     */
    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
    /**
     * Method that returns output child's average score
     */
    public Double getAverageScore() {
        return averageScore;
    }
    /**
     * Method that sets output child's average score
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }
    /**
     * Method that returns output child's score history
     */
    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }
    /**
     * Method that sets output child's score history
     */
    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }
    /**
     * Method that returns output child's budget for presents
     */
    public Double getAssignedBudget() {
        return assignedBudget;
    }
    /**
     * Method that sets output child's budget for presents
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }
    /**
     * Method that returns output child's received gifts
     */
    public ArrayList<GiftOutput> getReceivedGifts() {
        return receivedGifts;
    }
    /**
     * Method that sets output child's received gifts
     */
    public void setReceivedGifts(final ArrayList<GiftOutput> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
    /**
     * Method toString
     */
    @Override
    public String toString() {
        return "ChildOutput{"
                + "id=" + id
                + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + ", city='" + city + '\''
                + ", age=" + age
                + ", giftsPreferences=" + giftsPreferences
                + ", averageScore=" + averageScore
                + ", niceScoreHistory=" + niceScoreHistory
                + ", assignedBudget=" + assignedBudget
                + ", receivedGifts=" + receivedGifts
                + '}';
    }
}
