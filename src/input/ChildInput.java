package input;

import score.Score;

import java.util.ArrayList;

public class ChildInput {
    /**
     * Value of input child's ID
     */
    private int id;
    /**
     * Input child's last name
     */
    private String lastName;
    /**
     * Input child's first name
     */
    private String firstName;
    /**
     * Input child's age
     */
    private int age;
    /**
     * Input child's city
     */
    private String city;
    /**
     * Input child's nice score (first given)
     */
    private Score niceScore;
    /**
     * Input child's gifts preferences
     */
    private ArrayList<String> giftsPreferences;
    /**
     * Input child's bonus score
     */
    private Integer niceScoreBonus;
    /**
     * Input child's elf
     */
    private String elf;

    public ChildInput(final Integer id, final String lastName,
                      final String firstName, final Integer age, final String city,
                      final Double niceScore, final ArrayList<String> giftsPreferences,
                      final Integer niceScoreBonus, final String elf) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = new Score.ScoreBuilder(niceScore)
                .addNiceScoreBonus(niceScoreBonus)
                .build();
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
    }

    /**
     * Method that returns value of input child's ID
     */
    public int getId() {
        return id;
    }
    /**
     * Method that sets value of input child's ID
     */
    public void setId(final Integer id) {
        this.id = id;
    }
    /**
     * Method that returns input child's last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Method that sets input child's last name
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * Method that returns input child's first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Method that sets input child's first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * Method that returns input child's age
     */
    public int getAge() {
        return age;
    }
    /**
     * Method that sets input child's age
     */
    public void setAge(final Integer age) {
        this.age = age;
    }
    /**
     * Method that returns input child's city
     */
    public String getCity() {
        return city;
    }
    /**
     * Method that sets input child's city
     */
    public void setCity(final String city) {
        this.city = city;
    }
    /**
     * Method that returns input child's nice score (first given)
     */
    public Score getNiceScore() {
        return niceScore;
    }
    /**
     * Method that returns input child's nice score (first given)
     */
    public void setNiceScore(final Score niceScore) {
        this.niceScore = niceScore;
    }
    /**
     * Method that returns input child's gifts preferences
     */
    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }
    /**
     * Method that sets input child's gifts preferences
     */
    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
    /**
     * Method that returns input child's bonus score
     */
    public Integer getNiceScoreBonus() {
        return niceScoreBonus;
    }
    /**
     * Method that sets input child's bonus score
     */
    public void setNiceScoreBonus(final Integer niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }
    /**
     * Method that returns input child's elf
     */
    public String getElf() {
        return elf;
    }
    /**
     * Method that sets input child's elf
     */
    public void setElf(final String elf) {
        this.elf = elf;
    }

    /**
     * Method toString
     */
    @Override
    public String toString() {
        return "ChildInput{"
                + "id=" + id
                + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + ", age=" + age
                + ", city='" + city + '\''
                + ", niceScore=" + niceScore
                + ", giftsPreferences=" + giftsPreferences
                + '}';
    }
}
