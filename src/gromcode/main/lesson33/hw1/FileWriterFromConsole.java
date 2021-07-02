package gromcode.main.lesson33.hw1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class FileWriterFromConsole {
    public static void main(String[] args) {
        writeToFileFromConsole("/home/andrey/Desktop/test3.txt");
    }

    private static void writeToFileFromConsole(String path) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(
                    new FileWriter(path, true)
            );

            bw.append("\n");
            bw.append(getInputFromConsole());
        } catch (IOException e) {
            System.err.println("Can not write with path " + path + " no found");
            return;
        } finally {
            IOUtils.closeQuietly(bw);
        }

    }

    private static String getInputFromConsole() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String userInput = "";

        try {
            System.out.println("Enter file content to write in the file: ");
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard was failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(bufferedReader);
        }

        return userInput;
    }
}
