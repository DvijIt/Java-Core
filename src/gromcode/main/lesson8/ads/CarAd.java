package gromcode.main.lesson8.ads;

public class CarAd extends Ad {
    private int yearOfManufacturing;
    private String color;
    private String ownerName;
    private double weight;
    private int horsePower;

    public CarAd(long id, int price) {
        super(id, price);
    }

    void confirmAd() {
        // some logic
    }
}
