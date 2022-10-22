package elves;

import child.Child;

public final class WhiteElfStrategy implements ElfStrategy {
    @Override
    public void modifyBudget(final Child child) {
        // set new budget based on elf
        child.setChildBudget(child.getChildBudget());
    }
}
