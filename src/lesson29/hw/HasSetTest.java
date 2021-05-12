package lesson29.hw;

import lesson29.File;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HasSetTest {

    public static Set<Order> useHashSet() {
        Set<Order> orders = new HashSet<>();
        Set<Order> suborders = new HashSet<>();

        Order order1 = new Order(1001, 78978, "currency1", "itemName", "shopID");
        Order order2 = new Order(1002, 45654, "currency2", "itemName", "shopID");
        Order order3 = new Order(1003, 23423, "currency3", "itemName", "shopID");
        Order order4 = new Order(1004, 231241, "currency4", "itemName", "shopID");
        Order order5 = new Order(1005, 99234, "currency5", "itemName", "shopID");

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);

        Iterator<Order> fileIterator = orders.iterator();

        System.out.println("add");
        useIterator(fileIterator);
        orders.remove(order2);

        System.out.println("remove");
        for (Order order : orders) {
            System.out.println(order.getCurrency());
        }

        suborders.add(order3);
        suborders.add(order4);
        suborders.add(order5);
        orders.retainAll(suborders);

        System.out.println("retailAll");
        for (Order order : orders) {
            System.out.println(order.getCurrency());
        }

        System.out.println("size");
        System.out.println(orders.size());

        for (Order order : orders) {
            System.out.println(order.getCurrency());
        }

        return orders;
    }

    public static void useIterator(Iterator<Order> fileIterator) {
        while (fileIterator.hasNext()) {
            System.out.println(fileIterator.next().getCurrency());
        }
    }


}
