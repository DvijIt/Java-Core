package gromcode.main.lesson28.comparatorexample.comparators;

public class ComparatorUtils {
    public static <F extends Comparable<F>> int compareFields(F t1, F t2) {
        if (t1 == null && t2 == null) {
            return 0;
        } else if (t1 == null) {
            return 1;
        } else if (t2 == null) {
            return -1;
        } else {
            return t1.compareTo(t2);
        }
    }
}
