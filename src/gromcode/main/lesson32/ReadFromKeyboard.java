package gromcode.main.lesson32;

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
        System.out.println("Hello, " + scanner.nextLine());

        scanner.close();
    }

    public static void readKeyboardWithIOStream() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name");

        try {
            validateInput(br.readLine());
            System.out.println("Hello, " + br.readLine() + "!");
        } catch (IOException e) {
            System.err.println(e.getMessage() + "\n");
            System.out.println("Try again");
            readKeyboardWithIOStream();
        }
    }

    public static void validateInput(String input) throws IOException {
        if (input.split(" ").length > 1) {
            throw new IOException("Input must have one word");
        }

        for (char cr : input.toCharArray()) {
            if (!Character.isLetter(cr)) {
                throw new IOException("Input must have only letters");
            }
        }
    }
}
