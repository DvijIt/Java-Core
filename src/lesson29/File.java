package lesson29;

import java.util.Objects;

public class File {
    private String fileName;
    private long sizeInBites;

    public File(String fileName, long sizeInBites) {
        this.fileName = fileName;
        this.sizeInBites = sizeInBites;
    }

    public String getFileName() {
        return fileName;
    }

    public long getSizeInBites() {
        return sizeInBites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return fileName.equals(file.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, sizeInBites);
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", sizeInBites=" + sizeInBites +
                '}';
    }
}
