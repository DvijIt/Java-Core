package lesson15.task1.cast;

public class Demo {
    public static void main(String[] args) {
        InternetProvider provider = (InternetProvider) test();
        FoodProvider foodProvider = (FoodProvider) testFood();

        System.out.println(provider);
    }

    private static Provider test() {
        return new InternetProvider();
    }

    private static Provider testFood() {
        return new FoodProvider();
    }
}
