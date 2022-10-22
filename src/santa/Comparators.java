package santa;

import child.Child;
import delivery.City;
import gift.Gift;

import java.util.Comparator;

public class Comparators {
    public static class SortChildrenById implements Comparator<Child> {
        /**
         * Method that sort the list of children based on their ID
         * The smallest ID is first
         */
        @Override
        public int compare(final Child firstChild, final Child secondChild) {
            int diff = firstChild.getId().compareTo(secondChild.getId());
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static class SortGiftsByPrice implements Comparator<Gift> {
        /**
         * Method that sort the list of gifts based on their price
         * The smallest price is first
         */
        @Override
        public int compare(final Gift firstGift, final Gift secondGift) {
            int diff = firstGift.getPrice().compareTo(secondGift.getPrice());
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    public static class SortChildrenByNiceScoreCalculated implements Comparator<Child> {
        /**
         * Method that sort the list of children based on their ID
         * The smallest ID is first
         */
        @Override
        public int compare(final Child firstChild, final Child secondChild) {
            int diff = firstChild.getNiceScoreCalculated()
                    .compareTo(secondChild.getNiceScoreCalculated());
            if (diff > 0) {
                return -1;
            } else if (diff < 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    public static class SortCitiesByScore implements Comparator<City> {
        /**
         * Method that sort the list of children based on their ID
         * The smallest ID is first
         */
        @Override
        public int compare(final City firstCity, final City secondCity) {
            double diff = firstCity.getCityScoreCalculated() - secondCity.getCityScoreCalculated();
            if (diff > 0) {
                return -1;
            } else if (diff < 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    public static class SortCitiesByName implements Comparator<City> {
        /**
         * Method that sort the list of children based on their ID
         * The smallest ID is first
         */
        @Override
        public int compare(final City firstCity, final City secondCity) {
            return firstCity.getCityName().compareTo(secondCity.getCityName());
        }
    }
    public static class SortOutputChildrenById implements Comparator<ChildOutput> {
        /**
         * Method that sort the list of children based on their ID
         * The smallest ID is first
         */
        @Override
        public int compare(final ChildOutput firstChild, final ChildOutput secondChild) {
            int diff = firstChild.getId().compareTo(secondChild.getId());
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
