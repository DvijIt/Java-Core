package gromcode.main.lesson16.task2;

public class Solution {
    public static void main(String[] args) {
        String test = "There is Test something There new or jot sdf sdf sdf word Test op or or test Test";

        System.out.println(countWords(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));
        System.out.println(mostCountedWord(test));
        System.out.println(validate("https://somesite.ua"));
        System.out.println(validate("http://somesite.com"));
        System.out.println(validate("http://somesite.net"));
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

    public static boolean validate(String address) {
        if (address == null || address.isBlank() || getDomainLength(address) == 0 || getProtocolLength(address) == 0)
            return false;

        return isValidAddressName(address);
    }

    public static int getProtocolLength(String address) {
        String[] protocols = {"http://", "https://"};
        for (String protocol : protocols) {
            if (address.startsWith(protocol))
                return protocol.length();
        }

        return 0;
    }

    public static int getDomainLength(String address) {
        String[] domains = {".com", ".org", ".net"};

        for (String domain : domains) {
            if (address.endsWith(domain))
                return domain.length();
        }

        return 0;
    }

    public static String getAddressName(String address) {


        return address.substring(getProtocolLength(address), address.length() - getDomainLength(address));
    }

    public static boolean isValidAddressName(String address) {
        char[] addressNameChars = getAddressName(address).toLowerCase().toCharArray();

        for (char addressChar : addressNameChars) {
            if (Character.isLetterOrDigit(addressChar)) {
                return true;
            }
        }
        return false;
    }

//    97 122

}
