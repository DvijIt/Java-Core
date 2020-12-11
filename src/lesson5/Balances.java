package lesson5;

import java.util.Arrays;

public class Balances {
        public static void main(String[] args) {
            String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
            int[] balances = {100, 500, 8432, 99, 12000, -54, 0};

            System.out.println(Arrays.toString(findClientsByBalance(names, balances, -100)));
            System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));
            System.out.println(depositMoney(names, balances, "Ann", 2000));
        }

        static String[] findClientsByBalance(String[] clients, int[] balances, int n) {
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

        static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
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

        static int depositMoney(String[] clients, int[] balances, String client, int money) {
            return balances[findClientIndexByName(clients, client)] += money;
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

        static int calculateDepositAmountAfterCommission(int money) {
            return money <= 100 ? money : money;
        }
}
