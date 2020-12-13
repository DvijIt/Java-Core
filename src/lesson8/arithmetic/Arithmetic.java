package lesson8.arithmetic;

import java.util.Arrays;

public class Arithmetic {
    static boolean check(int[] array) {
        if (array == null) {
            return false;
        }
        Arrays.sort(array);
        return array[0] + array[array.length - 1] > 100;
    }

}
