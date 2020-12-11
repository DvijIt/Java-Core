package lesson5.task3;

import java.util.Arrays;
import java.util.Collections;

public class Task {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 6, 4, 20};
        sortAscending(arr);
        sortDescending(arr);
    }



    public static void sortAscending(Integer[] array) {
        //Сортируем массив
        Arrays.sort(array);
        //Выводим отсортированный массив на консоль.
        for (int j : array) {
            System.out.print(j + "  ");
        }
    }

    public static void sortDescending(Integer[] array) {
        //Сортируем массив
        Arrays.sort(array, Collections.reverseOrder());
        //Выводим отсортированный массив на консоль.
        for (int j : array) {
            System.out.print(j + "  ");
        }
    }
}
