package elves;

import child.Child;

public final class ElfStrategyFactory {
    private ElfStrategyFactory() {
    }
    /**
     * Method that creates a strategy using Factory Pattern to
     * establish the budget changes
     */
    public static ElfStrategy createElfStrategy(final Child child) {
        if (child.getElf().equals("yellow")) {
            return null;
        } else if (child.getElf().equals("black")) {
            return new BlackElfStrategy();
        } else if (child.getElf().equals("pink")) {
            return new PinkElfStrategy();
        } else if (child.getElf().equals("white")) {
            return new WhiteElfStrategy();
        }
        return null;
    }
}
