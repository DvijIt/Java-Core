package gromcode.main.lesson34.task3;

import java.io.*;

// Считать файл1
// Отсортировать предложения
// Записать их в файл1
// Записать их из файл2

public class Solution {
    public static void transferSentences(String fileFromPath, String fileToPath, String wordToCheck) throws Exception {
        validate(fileFromPath, fileToPath);
        String[] sentences = readFromFile(fileFromPath).toString().split("\\.");

        StringBuffer sentencesFromFile = new StringBuffer();
        StringBuffer sentencesToFile = new StringBuffer();

        for (String sentence : sentences) {
            if (sentence.length() > 10 && sentence.contains(wordToCheck)) {
                sentencesToFile.append(sentence);
            } else {
                sentencesFromFile.append(sentence);
            }
        }

        writeToFile(fileFromPath, sentencesFromFile, false);
        writeToFile(fileToPath, sentencesToFile, true);
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer content = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
                content.append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + "failed");
        }

        return content;
    }

    private static void writeToFile(String path, StringBuffer content, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
            if (isFileEmpty(path)) {
                bufferedWriter.append("\n");
            }
            bufferedWriter.append(getRefactoredContent(content));
        } catch (IOException e) {
            System.err.println("Can not write to file");
        }
    }

    private static StringBuffer getRefactoredContent(StringBuffer content) {
        if (content.length() != 0) {
            content.replace(content.length() - 1, content.length(), "");
        }

        return content;
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permission to be read");
        }

        if (!fileFrom.canWrite()) {
            throw new Exception("File " + fileTo + " does not have permission to be written");
        }
    }

    private static boolean isFileEmpty(String path) {
        File file = new File(path);
        return file.length() != 0;
    }
}
