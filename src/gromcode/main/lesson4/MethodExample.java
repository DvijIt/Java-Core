package gromcode.main.lesson4;

public class MethodExample {
    public static void main(String[] args) {
        System.out.println(increaser(5, 20));
        System.out.println(min(increaser(10, 5), 11));
    }

    public static int increaser(int a, int delta) {
        System.out.println("method invoked");
        a += delta;
        System.out.println("method before return");
        return a;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

}
