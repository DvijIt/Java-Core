package gromcode.main.lesson8.arithmetic;

import java.util.Arrays;

public class Arithmetic {
    public static void main(String[] args) {
        int[] array = {1, 234, 234, 444, -40};
        check(array);
    }
    static boolean check(int[] array) {
        if (array == null) {
            return false;
        }
        Arrays.sort(array);
        return array[0] + array[array.length - 1] > 100;
    }

}
