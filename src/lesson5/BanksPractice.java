package lesson5;

import java.util.Arrays;

public class BanksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina"};
        int[] balances = {100, 500, 8432, 99, 12000, -54};

        System.out.println(Arrays.toString(findClientsByBalance(names, balances, 10)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));
    }

    public static String[] findClientsByBalance(String[] clients, int[] balances, int n) {
        int count = 0;
        for (int balance : balances) {
            if (balance >= n) {
                count++;
            }
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance >= n) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }

        return results;
    }

    public static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
        int count = 0;
        for (int balance : balances) {
            if (balance < 0) {
                count++;
            }
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }

        return results;
    }

//    public static int depositMoney(String[] clients, int[] balances, String client, int money) {
//        //write code here
//    }
}
