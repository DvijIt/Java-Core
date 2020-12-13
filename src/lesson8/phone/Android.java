package lesson8.phone;

public class Android extends Phone {
    private String androidVersion;
    private int screenSize;
    private String secretDeviceCode;

    public Android(int price, double weight, String countryProduced, String androidVersion, int screenSize, String secretDeviceCode) {
        super(price, weight, countryProduced);
        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviceCode = secretDeviceCode;
    }


    void installNewAndroidVersion() {
        System.out.println("installNewAndroidVersion invoked...");
    };

}
