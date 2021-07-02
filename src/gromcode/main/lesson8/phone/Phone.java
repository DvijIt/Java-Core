package gromcode.main.lesson8.phone;

public class Phone  {
    private int price;
    private double weight;
    private String countryProduced;


    public Phone(int price, double weight, String countryProduced) {
        System.out.println("Phone constructor was invoked...");
        this.price = price;
        this.weight = weight;
        this.countryProduced = countryProduced;
    }

    void orderProduced() {
        System.out.println("order phone invoked...");
    }
}
