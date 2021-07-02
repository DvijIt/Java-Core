package gromcode.main.lesson6;

import gromcode.main.lesson6.task1.Car;
import gromcode.main.lesson6.task2.User;
import gromcode.main.lesson6.task3.DbConnector;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Car car = new Car(10000, 2015, "Anton");
        User user = new User();
        User user1 = new User("Andrei");
        User user2 = new User("Andrei", 24, "Krivoy Rog", new Date(), true);
        DbConnector connector1 = new DbConnector();
    }
}
