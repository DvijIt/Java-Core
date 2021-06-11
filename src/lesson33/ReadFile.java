package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadFile {

    public static void main(String[] args) {
        readFile("/home/andrey/Desktop/test.txt");
        writeFile("/home/andrey/Desktop/test1.txt");
        readFile("/home/andrey/Desktop/test1.txt");
    }

    private static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
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
            System.err.println("Reading from file " + path + "failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }

    private static void writeFile(String path) {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(path);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.append("\n");
            bufferedWriter.append("\nPPPPP");
        } catch (IOException e) {
            System.err.println("Can not write to file");
            return;
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }

    }
}
