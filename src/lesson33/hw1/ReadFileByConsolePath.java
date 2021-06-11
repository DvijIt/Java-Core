package lesson33.hw1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadFileByConsolePath {
    public static void main(String[] args) {
        readFileByConsolePath();
    }

    private static void readFileByConsolePath() {
        FileReader reader;
        try {
            reader = new FileReader(getPathFromConsole());
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            return;
        }

        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Reading from file " + getPathFromConsole() + "failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }

    }

    private static String getPathFromConsole() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String path = "";

        try {
            System.out.println("Enter path for reading a file: ");
            path = br.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard was failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }

        return path;
    }
}
