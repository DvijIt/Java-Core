package lesson34.task4;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Solution {
    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        validate(fileFrom, fileTo);

        Files.copy(fileFrom.toPath(), fileTo.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        validate(fileFrom, fileTo);

        FileUtils.copyFile(fileFrom, fileTo);
    }

    private static void validate(File fileFrom, File fileTo) throws Exception {

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

}
