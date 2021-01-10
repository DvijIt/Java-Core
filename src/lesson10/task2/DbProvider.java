package lesson10.task2;

public abstract class DbProvider {

    private String dbHost;

    abstract void connectToDb();

    abstract void disconnectToDb();

    void printDbHost() {
        System.out.println("Db host is" + dbHost);
    }
}
