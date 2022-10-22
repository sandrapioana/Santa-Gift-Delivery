package utils;

import changes.ChildUpdate;
import child.Child;
import common.Constants;
import delivery.City;
import elves.ElfStrategy;
import elves.ElfStrategyFactory;
import gift.Gift;
import input.ChildInput;
import input.GiftInput;
import org.json.simple.JSONArray;
import santa.ChildOutput;
import santa.GiftOutput;
import santa.SantaClaus;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public final class Utils {
    private Utils() {
    }
    /**
     * Method that transforms an array of JSON's into an array of strings
     */
    public static ArrayList<String> convertJSONArray(final JSONArray array) {
        if (array != null) {
            ArrayList<String> finalArray = new ArrayList<>();
            for (Object object : array) {
                finalArray.add((String) object);
            }
            return finalArray;
        } else {
            return null;
        }
    }
    /**
     * Method that calculates the budget for each child in santa's list
     */
    public static void calculateAllChildBudgets(final SantaClaus santa,
                                                final ArrayList<Child> children) {
        // calculate children's budgets
        for (int i = 0; i < children.size(); ++i) {
            children.get(i).calculateChildBudget(santa);
            if (!children.get(i).getElf().equals("yellow")) {
                //apply the strategy from the given elf if it is not yellow elf
                ElfStrategy elfStrategy = ElfStrategyFactory.createElfStrategy(children.get(i));
                elfStrategy.modifyBudget(children.get(i));
            }
        }
    }
    /**
     * Method that transforms an array of ChildInput into
     * an array of Child
     */
    public static ArrayList<Child> transformChildInputIntoChild(
            final List<ChildInput> childrenInput) {
        ArrayList<Child> children = new ArrayList<>();
        for (int i = 0; i < childrenInput.size(); ++i) {
            ChildInput newChild = childrenInput.get(i);
            children.add(new Child(newChild.getId(), newChild.getLastName(),
                    newChild.getFirstName(), newChild.getAge(), newChild.getCity(),
                    newChild.getNiceScore().getNiceScore(),
                    newChild.getNiceScore().getNiceScoreBonus(),
                    newChild.getGiftsPreferences(), newChild.getElf()));
        }
        return children;
    }
    /**
     * Method that transforms an array of GiftInput into
     * an array of Gift
     */
    public static ArrayList<Gift> transformGiftInputIntoGift(final List<GiftInput> giftInput) {
        ArrayList<Gift> gifts = new ArrayList<>();
        for (int i = 0; i < giftInput.size(); ++i) {
            GiftInput newGift = giftInput.get(i);
            gifts.add(new Gift(newGift.getProductName(), newGift.getPrice(),
                    newGift.getCategory(), newGift.getQuantity()));
        }
        return gifts;
    }
    /**
     * Method that updates the infos to an existing child
     * in santa's list
     */
    public static void updateChildInfos(final Child child, final ChildUpdate childUpdate) {
        if (!childUpdate.getNewScore().equals(Constants.INVALID_SCORE)) {
            child.setNiceScore(childUpdate.getNewScore());
        }
        // add new gift preferences
        for (int i = 0; i < childUpdate.getNewGiftsPreferences().size(); ++i) {
            child.getGiftsPreferences().add(i, childUpdate.getNewGiftsPreferences().get(i));
        }
        // remove duplicates in preferences
        child.setElf(childUpdate.getElf());
        Set<String> set = new LinkedHashSet<>();
        set.addAll(child.getGiftsPreferences());
        child.getGiftsPreferences().clear();
        child.getGiftsPreferences().addAll(set);
    }
    /**
     * Method that calculate average score of each city
     */
    public static void calculateCitiesAverage(final ArrayList<City> cities) {
        // set the average score of each city
        for (City city : cities) {
            city.setCityScoreCalculated(city.getCityScore() / city.getChildrenFromThisCity());
        }
    }
    /**
     * Method that adds a child to the list of output
     */
    public static void addChildToOutput(final Child thisChild,
                                        final ArrayList<ChildOutput> output,
                                        final ArrayList<GiftOutput> receivedGifts) {
        // add a child in the output list
        int id = thisChild.getId();
        String lastName = thisChild.getLastName();
        String firstName = thisChild.getFirstName();
        String city = thisChild.getCity();
        int age = thisChild.getAge();
        ArrayList<String> giftsPreferences = new ArrayList<>(thisChild.getGiftsPreferences());
        double niceScoreCalculated = thisChild.getNiceScoreCalculated();
        ArrayList<Double> history = new ArrayList<>(thisChild.getNiceScoreHistory());
        double budgetChild = thisChild.getChildBudget();
        ChildOutput giftedChild = new ChildOutput(id, lastName, firstName, city,
                age, giftsPreferences, niceScoreCalculated, history, budgetChild,
                receivedGifts);

        output.add(giftedChild);
    }
}
