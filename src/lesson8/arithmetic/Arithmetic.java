package lesson8.arithmetic;

import java.util.Arrays;

public class Arithmetic {
    static boolean check(int[] array) {
        Arrays.sort(array);
        return array[0] + array[array.length - 1] > 100;
    }

}
