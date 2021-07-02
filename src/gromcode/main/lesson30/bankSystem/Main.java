package gromcode.main.lesson30.bankSystem;

public class Main {
    public static void main(String[] args) {
        Bank euBank = new EUBank(1222, "Germany", Currency.EUR, 50, 11400, 4, 1233456789);
        Bank usBank = new USBank(122, "USA", Currency.USD, 46, 12500, 2, 223456789);
        Bank chinaBank = new ChinaBank(11, "China", Currency.USD, 79, 1520, 2, 1987455456);


        User euUser1 = new User(1001, "Vanya", 12200, 40, "DVIJc", 1500, euBank);
        User euUser2 = new User(133, "Andrey", 500, 40, "DVIJc", 1500, euBank);
        User usUser1 = new User(800, "Vitalik", 900, 40, "DVIJc", 600, usBank);
        User usUser2 = new User(465, "Denis", 12200, 40, "DVIJc", -500, usBank);
        User chinaUser1 = new User(9, "Dima", 805, 40, "DVIJc", 700, chinaBank);
        User chinaUser2 = new User(5, "Vasya", 3000, 40, "DVIJc", 1500, chinaBank);

        User[] users = new User[]{euUser1, euUser2, usUser1, usUser2, chinaUser1, chinaUser2};

        BankSystem bankSystem = new UkrainianBankSystem();

        checkUpBankSystemMethods(users, bankSystem, euUser1, 50);
        checkUpBankSystemMethods(users, bankSystem, usUser1, 70);
    }

    private static void checkUpBankSystemMethods(User[] users, BankSystem bankSystem, User toUser, int amount) {
        for (User user : users) {
            System.out.println("Amount of money is " + amount);

            PrintUserAction(user, " balance before withdraw ");
            bankSystem.withdraw(user, amount);
            PrintUserAction(user, " balance after withdraw ");

            PrintUserAction(user, " balance before transferMoney ");
            bankSystem.transferMoney(user, toUser, amount);
            PrintUserAction(user, " balance before transferMoney ");

            PrintUserAction(user, " balance before paySalary ");
            bankSystem.paySalary(user);
            PrintUserAction(user, " balance after paySalary ");

            PrintUserAction(user, " balance before fund ");
            bankSystem.fund(user, amount);
            PrintUserAction(user, " balance before fund ");
        }
    }

    private static void PrintUserAction(User user, String massage) {
        System.out.println(user.getName() + massage + user.getBalance());
    }

}