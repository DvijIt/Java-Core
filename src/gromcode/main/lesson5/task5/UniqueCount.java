package gromcode.main.lesson5.task5;

public class UniqueCount {

    public static void main(String[] args) {
        int[] array = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11, 3};
        System.out.println(uniqueCount(array));
    }

    public static int uniqueCount(int[] array) {
        int result = 0;
        int countUnique = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            countUnique++;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i])
                {
                    count++;
                    break;
                }
            }
        }
        return result = countUnique - count;
    }

}
