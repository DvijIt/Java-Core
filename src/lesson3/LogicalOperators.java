package lesson3;

public class LogicalOperators {
    public static void main(String[] args) {
        System.out.println(false && false);
        System.out.println(false && true);
        System.out.println(false && true);
        System.out.println(true && true);

//        int a;
//        byte b = 100;
//
//        a = b > 200 ? b : b - 500;
//        System.out.println(a);

        int a = 60;
        int b = 13;
        int c = 0;

        c = a & b;
        System.out.println("a & b = " + c);
        c = a | b;
        System.out.println("a | b = " + c);
        c = a ^ b;
        System.out.println("a ^ b = " + c);
        c = a << 2;
        System.out.println("a << 2 = " + c);
        c = a >> 2;
        System.out.println("a >> 2 = " + c);
    }
}
