package lesson27.hw1;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        useList();
    }

    public static LinkedList<Order> useList() {
        LinkedList<Order> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            Order order = new Order(i, i, "currency" + i, "itemName" + i, "shop" + i);
            linkedList.add(order);
        }

        Order newOrder = new Order(17, 17, "currency", "itemName", "shop");
        linkedList.add(linkedList.size(), newOrder);
        System.out.println("add(int index, E element)" + linkedList);

        linkedList.remove(3);
        linkedList.remove(newOrder);

        LinkedList<Order> CollectionLinkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Order order = new Order(i, i, "currency" + i, "itemName" + i, "shop" + i);
            CollectionLinkedList.add(order);
        }
        linkedList.addAll(CollectionLinkedList);

        linkedList.subList(0, 2);

        linkedList.set(0, newOrder);

        linkedList.contains(newOrder);
        System.out.println("linkedList.contains(newOrder): " + linkedList.contains(newOrder));
        linkedList.toArray();
        System.out.println("linkedList.toArray(): " + linkedList.toArray());
        System.out.println(linkedList);
        linkedList.clear();

        System.out.println(linkedList);
        return linkedList;
    }
}
