package lesson4;

public class FindDif {
    public static void main(String[] args) {
        System.out.println(findDivCount(20000, 30000, 333));
    }

    public static int findDivCount(int a, int b, int n) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0) {
                count++;
            }
        }

        return count;
    }
}
