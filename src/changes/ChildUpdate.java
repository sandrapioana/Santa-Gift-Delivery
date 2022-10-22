package changes;

import java.util.ArrayList;

public class ChildUpdate {
    /**
     * Value of child's ID
     */
    private final Integer id;
    /**
     * Value of child's new score
     */
    private final Double newScore;
    /**
     * List with child's new gift preferences
     */
    private final ArrayList<String> newGiftsPreferences;
    /**
     * String that contains the updated elf type of the child
     */
    private final String elf;

    public ChildUpdate(final Integer id, final Double newScore,
                       final ArrayList<String> newGiftsPreferences,
                       final String elf) {
        this.id = id;
        this.newScore = newScore;
        this.newGiftsPreferences = newGiftsPreferences;
        this.elf = elf;
    }
    /**
     * Method that returns child's new ID
     */
    public Integer getId() {
        return id;
    }
    /**
     * Method that returns child's new score
     */
    public Double getNewScore() {
        return newScore;
    }
    /**
     * Method that returns list to child's new gift preferences
     */
    public ArrayList<String> getNewGiftsPreferences() {
        return newGiftsPreferences;
    }
    /**
     * Method that returns child's new elf
     */
    public String getElf() {
        return elf;
    }
}
