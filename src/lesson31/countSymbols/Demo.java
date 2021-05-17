package lesson31.countSymbols;

public class Demo {
    public static void main(String[] args) {
        String text = "qweqwr qweqwr #ffdgdg qwewq$^$%aa Andrei (&*()Bezverkhnii sergeevich!";

        System.out.println(Solution.countSymbols(text));

        System.out.println(Solution.words(text));
    }
}
