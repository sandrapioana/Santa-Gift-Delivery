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

public final class IdStrategy implements DeliveryStrategy {
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

        // make a list for children who don't receive a gift
        ArrayList<Child> childWithNoGift = new ArrayList<>();

        // calculate score for every child
        for (int i = 0; i < santa.getChildren().size(); ++i) {
            ScoreStrategy strategy = ScoreStrategyFactory
                    .createStrategy(santa.getChildren().get(i));
            strategy.calculateScore(santa.getChildren().get(i));
        }

        // calculate budget unit and budget for every child
        Solver.calculateBudgetUnit();
        Utils.calculateAllChildBudgets(santa, santa.getChildren());


        for (int i = 0; i < santa.getChildren().size(); ++i) {
            // child's budget
            double budget = santa.getChildren().get(i).getChildBudget();

            // list for received gifts
            ArrayList<GiftOutput> receivedGifts = new ArrayList<>();
            for (int k = 0; k < santa.getChildren().get(i).getGiftsPreferences().size(); ++k) {
                for (int j = 0; j < santa.getGifts().size(); ++j) {
                    if (santa.getChildren().get(i).getGiftsPreferences().get(k)
                            .equals(santa.getGifts().get(j).getCategory())) {
                        if (santa.getGifts().get(j).getQuantity() > 0) {
                            if (budget > santa.getGifts().get(j).getPrice()) {
                                // add in the receivedGifts the gift that the child got
                                receivedGifts.add(new GiftOutput(
                                        santa.getGifts().get(j).getProductName(),
                                        santa.getGifts().get(j).getPrice(),
                                        santa.getGifts().get(j).getCategory()));

                                // decrease budget
                                budget = budget - santa.getGifts().get(j).getPrice();

                                // decrement quantity of the given gift
                                santa.getGifts().get(j).setQuantity(
                                        santa.getGifts().get(j).getQuantity() - 1);
                                break;
                            }
                        }
                    }
                }
            }

            // if the child doesn't have yellow elf
            if (!santa.getChildren().get(i).getElf().equals("yellow")) {
                Child thisChild = santa.getChildren().get(i);
                Utils.addChildToOutput(thisChild, output, receivedGifts);
            } else {
                if (receivedGifts.size() == 0) {
                    // child has yellow elf and did not receive any gift
                    childWithNoGift.add(santa.getChildren().get(i));
                } else {
                    // child has yellow elf and received a gift
                    Child thisChild = santa.getChildren().get(i);
                    Utils.addChildToOutput(thisChild, output, receivedGifts);
                }
            }
        }

        // giving only a gift to the children that did not receive any gifts
        // and if the cheapest one in the preferred category is available
        for (int i = 0; i < childWithNoGift.size(); ++i) {
            int getAGift = 0;
            ArrayList<GiftOutput> receivedGifts = new ArrayList<>();
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
