package lesson34.task4;

public class Demo {
    public static void main(String[] args) throws Exception {
        Solution.copyFileContent("/home/andrey/Desktop/test1.txt", "/home/andrey/Desktop/test2.txt");
        Solution.copyFileContentApacheIO("/home/andrey/Desktop/test1.txt", "/home/andrey/Desktop/test2.txt");
    }
}
