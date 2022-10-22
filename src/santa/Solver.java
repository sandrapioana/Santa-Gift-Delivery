package santa;

import changes.AnnualChange;
import child.Child;
import common.Constants;
import delivery.DeliveryStrategy;
import delivery.DeliveryStrategyFactory;
import gift.Gift;
import input.ChildInput;
import input.GiftInput;
import utils.Utils;

import java.util.ArrayList;

public final class Solver {
    private Solver() {
    }
    /**
     * Method that initialize santa's fields
     */
    public static void initializeSantaClaus(final Double santaBudget,
                                            final ArrayList<Child> children,
                                            final ArrayList<Gift> gifts) {
        SantaClaus.getSantaClaus().setSantaBudget(santaBudget);
        SantaClaus.getSantaClaus().setChildren(children);
        SantaClaus.getSantaClaus().setGifts(gifts);
        SantaClaus.getSantaClaus().setBudgetUnit(0.0);
    }
    /**
     * Method that calculates the budget unit
     */
    public static void calculateBudgetUnit() {
        SantaClaus santa = SantaClaus.getSantaClaus();
        double totalAverages = 0;
        for (int i = 0; i < santa.getChildren().size(); ++i) {
            totalAverages = totalAverages + santa.getChildren().get(i).getNiceScoreCalculated();
        }
        if (totalAverages != 0) {
            santa.setBudgetUnit(santa.getSantaBudget() / totalAverages);
        }
    }
    /**
     * Method that updates santa's info regarding budget, children list and gifts list
     */
    public static void updateInfo(final AnnualChange annualChange) {
        SantaClaus santa = SantaClaus.getSantaClaus();
        // set new budget
        if (annualChange.getNewSantaBudget() != null) {
            santa.setSantaBudget(annualChange.getNewSantaBudget());
        }

        // add new gifts
        if (annualChange.getNewGifts() != null) {
            for (int i = 0; i < annualChange
                    .getNewGifts().size(); ++i) {
                GiftInput inputGift = annualChange.getNewGifts().get(i);
                santa.getGifts().add(new Gift(inputGift.getProductName(), inputGift.getPrice(),
                        inputGift.getCategory(), inputGift.getQuantity()));
            }
        }

        // update existing children
        if (annualChange.getChildrenUpdate() != null) {
            for (int i = 0; i < annualChange.getChildrenUpdate().size(); ++i) {
                for (int j = 0; j < santa.getChildren().size(); ++j) {
                    if (annualChange.getChildrenUpdate().get(i)
                            .getId().equals(santa.getChildren().get(j).getId())) {
                        Utils.updateChildInfos(santa.getChildren().get(j),
                                annualChange.getChildrenUpdate().get(i));
                        break;
                    }
                }
            }
        }

        // add the new children
        if (annualChange.getNewChildren() != null) {
            for (int i = 0; i < annualChange.getNewChildren().size(); ++i) {
                ChildInput newChild = annualChange.getNewChildren().get(i);
                santa.getChildren().add(new Child(newChild.getId(), newChild.getLastName(),
                        newChild.getFirstName(), newChild.getAge(), newChild.getCity(),
                        newChild.getNiceScore().getNiceScore(),
                        newChild.getNiceScore().getNiceScoreBonus(),
                        newChild.getGiftsPreferences(), newChild.getElf()));
            }
        }
    }
    /**
     * Method that increments all children's ages
     */
    public static void changeAge() {
        SantaClaus santa = SantaClaus.getSantaClaus();
        // increment age for each child
        for (int i = 0; i < santa.getChildren().size(); ++i) {
            santa.getChildren().get(i).setAge(santa.getChildren().get(i).getAge() + 1);
        }
        santa.getChildren().removeIf((child) -> child.getAge() > Constants.MAX_AGE);
        Comparators.SortChildrenById sortId = new Comparators.SortChildrenById();
        santa.getChildren().sort(sortId);
    }
    /**
     * Method that returns a list with output children with their info
     * and received gifts from santa
     */
    public static ArrayList<ChildOutput> giveGifts(final String annualStrategy) {
        SantaClaus santa = SantaClaus.getSantaClaus();
        // strategy for delivery
        DeliveryStrategy deliveryStrategy = DeliveryStrategyFactory
                .createDeliveryStrategy(annualStrategy);
        return deliveryStrategy.makeDelivery(santa);
    }
}
