package gromcode.main.lesson10.task1;

public class User extends Human {
    public User(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("User class is called...");
        super.run();
    }
}
