package lesson8.arithmetic;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 4, 20};
        Arithmetic arithmetic = new Arithmetic();
        Adder adder = new Adder();
        arithmetic.check(arr);
        System.out.println(Adder.check(arr));
        System.out.println(Adder.add(2,6));
    }
}
