package gromcode.main.lesson18.task4;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] text = {"gfdffr 112s 55", "222 222.22", null};

        for (String textItem : text) {
            System.out.println(Arrays.toString(findNumbers(textItem)));
        }
    }

    public static int[] findNumbers(String text) {
        if (text == null) {
            return new int[0];
        }

        String[] words = text.split(" ");

        int count = 0;

        for (String word : words) {
            if (hasOnlyDigits(word)) {
                count++;
            }
        }

        int[] resultArray = new int[count];
        int index = 0;

        for (String word : words) {
            if (hasOnlyDigits(word)) {
                resultArray[index] = Integer.parseInt(word);
                index++;
            } else {
                System.err.println(word + " not a number");
            }
        }

        return resultArray;
    }

    private static boolean hasOnlyDigits(String word) {
        if (word.isBlank()) {
            return false;
        }

        for (char aChar : word.toCharArray()) {
            if (!Character.isDigit(aChar)) {
                return false;
            }
        }
        return true;
    }
}
