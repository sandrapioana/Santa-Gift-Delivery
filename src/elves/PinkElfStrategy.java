package elves;

import child.Child;
import common.Constants;

public final class PinkElfStrategy implements ElfStrategy {
    @Override
    public void modifyBudget(final Child child) {
        // set new budget based on elf
        child.setChildBudget(child.getChildBudget()
                + child.getChildBudget() * Constants.THIRTY / Constants.PERCENT);
    }
}
