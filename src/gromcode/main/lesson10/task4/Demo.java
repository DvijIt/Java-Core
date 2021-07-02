package gromcode.main.lesson10.task4;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Витя", "Киев", "Мужской");
        Customer customer2 = new Customer("Алена", "Одесса", "Женский");
        Customer customer3 = new Customer("Тест", "Киев", "Мужской");
        Customer customer4 = new Customer("Андрей", "Кривой Рог", "Мужской");


        String[] cities = {"Киев", "Одесса", "Днепр", "Кривой Рог", "Львов"};
        Customer[] customers = new Customer[]{customer1, customer2, customer3, customer4};


        checkElectronicsOrder(customers, cities, 500);
        checkFurnitureOrder(customers, cities, 2300);

    }


    private static void checkElectronicsOrder(Customer[] customers, String[] shipToCity, int price) {
        for (Customer customer : customers) {
            for (String city : shipToCity) {
                ElectronicsOrder electronicsOrder = new ElectronicsOrder("ElectronicsOrder", new Date(), customer.getCity(), city, price, customer, 5);

                System.out.println("Before validation " + electronicsOrder.getItemName() + " " + customer.getName());
                electronicsOrder.validateOrder();

                if (electronicsOrder.getDateConfirmed() != null) {
                    electronicsOrder.calculatePrice();
                    electronicsOrder.confirmShipping();
                }

                System.out.println("After validation" + electronicsOrder.getItemName() + " " + customer.getName());
            }
        }
    }

    private static void checkFurnitureOrder(Customer[] customers, String[] shipToCity, int price) {
        for (Customer customer : customers) {
            for (String city : shipToCity) {
                FurnitureOrder furnitureOrder = new FurnitureOrder("FurnitureOrder1", new Date(), customer.getCity(), city, price, customer, "54");

                System.out.println("Before validation " + furnitureOrder.getItemName() + " " + customer.getName());
                furnitureOrder.validateOrder();

                if (furnitureOrder.getDateConfirmed() != null) {
                    furnitureOrder.calculatePrice();
                    furnitureOrder.confirmShipping();
                }
                System.out.println("After validation " + furnitureOrder.getItemName() + " " + customer.getName());
            }
        }
    }
}
