package gromcode.main.lesson34;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) {
        readFile("/home/andrey/Desktop/test.txt");
        writeFile("/home/andrey/Desktop/test2.txt");
    }

    private static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + "failed");
        }
    }

    private static void writeFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append("\n");
            bufferedWriter.append("\nPPPPP");
        } catch (IOException e) {
            System.err.println("Can not write to file");
        }
    }
}
