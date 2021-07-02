package gromcode.main.lesson30.bankSystem;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Bank euBank = new EUBank(1222, "Germany", Currency.EUR, 50, 11400, 4, 1233456789);
        UkrainianBankSystem ukrainianBankSystem = new UkrainianBankSystem();

        User user = new User(133, "Andrey", 500, 40, "DVIJc", 1500, euBank);

        ukrainianBankSystem.withdraw(user, 150);
        Thread.sleep(100);
        ukrainianBankSystem.withdraw(user, 10);
        Thread.sleep(100);
        ukrainianBankSystem.paySalary(user);

        System.out.println(ukrainianBankSystem.getTransaction());
    }
}
