package lesson31.countSymbols;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static Map<Character, Integer> countSymbols(String text) {
        Map<Character, Integer> countSymbols = new TreeMap<>();

        for (char cr : text.toCharArray()) {
            if (Character.isLetter(cr)) {
                if (countSymbols.containsKey(cr)) {
                    countSymbols.put(cr, countSymbols.get(cr) + 1);
                } else {
                    countSymbols.put(cr, 1);
                }
            }
        }
        return countSymbols;
    }

    public static Map<String, Integer> words(String text) {
        Map<String, Integer> countWords = new TreeMap<>();

        for (String str : text.split(" ")) {
            if (str.length() > 2) {
                if (countWords.containsKey(str)) {
                    countWords.put(str, countWords.get(str) + 1);
                } else {
                    countWords.put(str, 1);
                }
            }
        }

        return countWords;
    }

}
