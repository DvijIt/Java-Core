package gromcode.main.lesson6.task1;

public class Car {
    // fields
    private int price;
    private int yearOfManufacturing;
    private String color;
    private String ownerName;
    private double weight;
    private int horsePower;

    // constructors

    public Car(int price, int yearOfManufacturing, String ownerName) {
        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
        this.ownerName = ownerName;
    }

    // methods

    public void startRun() {
        System.out.println("I am running...");
    }

    public void stopRun() {
        System.out.println("I am stopping...");
    }

    void changeOwner(String newOwnerName) {
        ownerName = newOwnerName;
    }
}
