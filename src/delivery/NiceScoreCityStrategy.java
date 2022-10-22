package delivery;

import child.Child;
import child.ScoreStrategy;
import child.ScoreStrategyFactory;
import common.Constants;
import santa.ChildOutput;
import santa.Comparators;
import santa.GiftOutput;
import santa.SantaClaus;
import utils.Utils;
import santa.Solver;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public final class NiceScoreCityStrategy implements DeliveryStrategy {
    @Override
    public ArrayList<ChildOutput> makeDelivery(final SantaClaus santa) {
        // sort gifts by price
        Comparators.SortGiftsByPrice sortPrice = new Comparators.SortGiftsByPrice();
        santa.getGifts().sort(sortPrice);

        // create an output list
        ArrayList<ChildOutput> output = new ArrayList<>();

        // sort children by id
        Comparators.SortChildrenById sortId = new Comparators.SortChildrenById();
        santa.getChildren().sort(sortId);

        // remove children with the age above 18
        santa.getChildren().removeIf((child) -> child.getAge() > Constants.MAX_AGE);

        // calculate score for every child
        for (int i = 0; i < santa.getChildren().size(); ++i) {
            ScoreStrategy strategy = ScoreStrategyFactory.
                    createStrategy(santa.getChildren().get(i));
            strategy.calculateScore(santa.getChildren().get(i));
        }

        // calculate budget unit and budget for every child
        Solver.calculateBudgetUnit();
        Utils.calculateAllChildBudgets(santa, santa.getChildren());

        // create a list that contains City entities
        ArrayList<City> cities = new ArrayList<>();

        // create a list that contains the name of all cities
        ArrayList<String> nameOfCities = new ArrayList<>();

        // add all the city names from every child
        for (int i = 0; i < santa.getChildren().size(); ++i) {
            nameOfCities.add(santa.getChildren().get(i).getCity());
        }

        // remove duplicates
        Set<String> set = new LinkedHashSet<>();
        set.addAll(nameOfCities);
        nameOfCities.clear();
        nameOfCities.addAll(set);
        // make City entities for each city
        for (int i = 0; i < nameOfCities.size(); ++i) {
            cities.add(new City(nameOfCities.get(i)));
        }
        // calculate for each City its score
        for (int i = 0; i < santa.getChildren().size(); ++i) {
            for (int j = 0; j < cities.size(); ++j) {
                if (santa.getChildren().get(i).getCity().equals(cities.get(j).getCityName())) {
                    cities.get(j).setCityScore(cities.get(j).getCityScore()
                            + santa.getChildren().get(i).getNiceScoreCalculated());
                    cities.get(j).setChildrenFromThisCity(
                            cities.get(j).getChildrenFromThisCity() + 1);
                    break;
                }
            }
        }
        // calculate for each City its average
        Utils.calculateCitiesAverage(cities);
        // sort Cities by name
        Comparators.SortCitiesByName sortCitiesName = new Comparators.SortCitiesByName();
        cities.sort(sortCitiesName);
        // sort Cities by their average score in descending order
        Comparators.SortCitiesByScore sortCities = new Comparators.SortCitiesByScore();
        cities.sort(sortCities);
        // make a list for children who don't receive a gift
        ArrayList<Child> childWithNoGift = new ArrayList<>();
        // the first criteria in giving gifts is the city, so firstly
        // search for children who live in that city
        for (int i = 0; i < cities.size(); ++i) {
            for (int j = 0; j < santa.getChildren().size(); ++j) {
                if (santa.getChildren().get(j).getCity().equals(cities.get(i).getCityName())) {
                    // child's budget
                    double budget = santa.getChildren().get(j).getChildBudget();

                    // list for received gifts
                    ArrayList<GiftOutput> receivedGifts = new ArrayList<>();
                    for (int k = 0; k < santa.getChildren().get(j)
                            .getGiftsPreferences().size(); ++k) {
                        for (int l = 0; l < santa.getGifts().size(); ++l) {
                            if (santa.getChildren().get(j).getGiftsPreferences().get(k)
                                    .equals(santa.getGifts().get(l).getCategory())) {
                                if (santa.getGifts().get(l).getQuantity() > 0) {
                                    if (budget > santa.getGifts().get(l).getPrice()) {
                                        // add in the receivedGifts the gift that the child got
                                        receivedGifts.add(new GiftOutput(
                                                santa.getGifts().get(l).getProductName(),
                                                santa.getGifts().get(l).getPrice(),
                                                santa.getGifts().get(l).getCategory()));
                                        // decrease budget
                                        budget = budget - santa.getGifts().get(l).getPrice();
                                        // decrement quantity of the given gift
                                        santa.getGifts().get(l).setQuantity(
                                                santa.getGifts().get(l).getQuantity() - 1);
                                        break;
                                    }
                                }

                            }
                        }
                    }
                    // if the child doesn't have yellow elf
                    if (!santa.getChildren().get(j).getElf().equals("yellow")) {
                        Child thisChild = santa.getChildren().get(j);
                        Utils.addChildToOutput(thisChild, output, receivedGifts);
                    } else {
                        if (receivedGifts.size() == 0) {
                            // child has yellow elf and did not receive any gift
                            childWithNoGift.add(santa.getChildren().get(j));
                        } else {
                            // child has yellow elf and received a gift
                            Child thisChild = santa.getChildren().get(j);
                            Utils.addChildToOutput(thisChild, output, receivedGifts);
                        }
                    }
                }
            }
        }
        // giving only a gift to the children that did not receive any gifts
        // and if the cheapest one in the preferred category is available
        for (int i = 0; i < childWithNoGift.size(); ++i) {
            ArrayList<GiftOutput> receivedGifts = new ArrayList<>();
            int getAGift = 0;
            if (childWithNoGift.get(i).getGiftsPreferences().size() != 0) {
                String preferredGift = childWithNoGift.get(i).getGiftsPreferences().get(0);
                for (int k = 0; k < santa.getGifts().size() && getAGift == 0; ++k) {
                    if (santa.getGifts().get(k).getCategory().equals(preferredGift)) {
                        getAGift = 1;
                        if (santa.getGifts().get(k).getQuantity() != 0) {
                            receivedGifts.add(new GiftOutput(
                                    santa.getGifts().get(k).getProductName(),
                                    santa.getGifts().get(k).getPrice(),
                                    santa.getGifts().get(k).getCategory()));
                            santa.getGifts().get(k).setQuantity(
                                    santa.getGifts().get(k).getQuantity() - 1);
                        }
                    }
                }
            }
            // add the child in the output list
            Child thisChild = childWithNoGift.get(i);
            Utils.addChildToOutput(thisChild, output, receivedGifts);
        }
        // sort the output list based on children's id
        Comparators.SortOutputChildrenById sortOutputId = new Comparators.SortOutputChildrenById();
        output.sort(sortOutputId);
        return output;
    }
}
