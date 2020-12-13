package lesson8.arithmetic;

public class Demo {
    public static void main(String[] args) {
        int[] array = {1, 234, 234, 444, -40};
        System.out.println(Adder.check(array));
        System.out.println(Adder.add(2,6));

        System.out.println(Adder.add(4, 6));
        System.out.println(Adder.add(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println();

        int[] array1 = {1, 66, 35, 100, 55};
        System.out.println(Arithmetic.check(array1));

        System.out.println(Arithmetic.check(null));
        System.out.println();
    }
}
