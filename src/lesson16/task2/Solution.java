package lesson16.task2;

public class Solution {
    public static void main(String[] args) {
        String test = "There is Test something There new or jot sdf sdf sdf word Test op or or test Test";

        System.out.println(countWords(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));
        System.out.println(mostCountedWord(test));
    }

    public static int countWords(String input) {
        return input.trim().split(" ").length;
    }

    public static String maxWord(String input) {
        String[] words = input.trim().split(" ");

        String res = words[0];

        for (String word : words) {
            if (word.length() > res.length())
                res = word;
        }
        return res;
    }

    public static String minWord(String input) {
        String[] words = input.trim().split(" ");

        String res = words[0];

        for (String word : words) {
            if (word.length() < res.length())
                res = word;
        }
        return res;
    }

    public static String mostCountedWord(String input) {
        if (input.isEmpty())
            return null;

        String[] words = input.trim().split(" ");

        String res = words[0];
        int currentCount = 0;
        int findCount = 0;

        for (String i : words) {
            for (String j : words) {
                if (isWord(i) && isWord(j) && i.equals(j)) {
                    currentCount++;
                    if (currentCount > findCount) {
                        findCount = currentCount;
                        currentCount = 0;
                        res = i;
                    }
                }
            }
        }

        return res;
    }

    public static boolean isWord(String input) {
        return !input.isEmpty() && !input.isBlank();
    }

    public static int[] countDuplicates(String input, String[] words) {
        String[] strings = input.split(" ");

        int[] res = new int[words.length];

        for (String string : strings) {
            for (int i = 0; i < words.length; i++) {
                if (string.equals(words[i])) {
                    res[i]++;
                }
            }
        }
        return res;
    }

}
