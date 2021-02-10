package lesson16.task1;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String test = "someString";

        System.out.println(test.isEmpty());
        System.out.println("".isEmpty());
        System.out.println(test.length());
        System.out.println(test.charAt(2));
        System.out.println(test.replace("e", "t"));
        System.out.println(test.contains("e"));
        System.out.println(Arrays.toString(test.split("")));
        System.out.println(test.trim());

        System.out.println(test.substring(2));
        System.out.println(test.substring(2, 8));
        System.out.println(test.toUpperCase());
        System.out.println(test.toLowerCase());

    }
}
