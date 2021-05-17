package lesson32;

import lesson24.exercise.Sys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {

    public static void main(String[] args) throws IOException {

        readKeyboardWithIOStream();

    }

    public static void readKeyboardWithScanner() throws Exception {
        //using scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name");

        if (validateStringInput(scanner.nextLine())) {
            throw new Exception("Input must have one word");
        }

        for (char cr : scanner.nextLine().toCharArray()) {
            if (!validateCharInput(cr)) {
                throw new Exception("Input must have only letters");
            }
        }

        System.out.println("Hello, " + scanner.nextLine());

        scanner.close();
    }

    public static void readKeyboardWithIOStream() throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name");
        System.out.println("Hello, " + br.readLine() + "!");
    }

    public static boolean validateCharInput(Character character) {
        return Character.isLetter(character);
    }

    public static boolean validateStringInput(String line) {
        return line.split(" ").length == 1;
    }
}
