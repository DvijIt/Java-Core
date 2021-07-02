package gromcode.main.lesson5.task4;

public class Withdraw {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, 99, 12000, -54, 0};
        System.out.println(withdraw(names, balances, "Ann", 10));
    }

    public static int withdraw(String[] clients, int[] balances, String client, int money) {
        if (balances[findClientIndexByName(clients, client)] < money) {
            return -1;
        }
        return balances[findClientIndexByName(clients, client)] -= money;
    }

    public static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl.equals(client)) {
                break;
            }
            clientIndex++;
        }
        return clientIndex;
    }

}
