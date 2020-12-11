package lesson5.task3;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 4, 20};
        System.out.println(Arrays.toString(sortAscending(arr)));;
        System.out.println(Arrays.toString(sortDescending(arr)));;
    }



    public static int[] sortAscending(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public static int[] sortDescending(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] >= array[j]) {
                    int x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;
    }
}
