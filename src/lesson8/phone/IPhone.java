package lesson8.phone;

public class IPhone extends Phone {
    public IPhone(int price, double weight, String countryProduced, boolean fingerPrint) {
        super(price, weight, countryProduced);

        System.out.println("IPhone constructor was invoked...");
        this.fingerPrint = fingerPrint;
    }

    private boolean fingerPrint;

    public void deleteIPhoneFromDb() {
        System.out.println("deleteIPhoneFromDb invoked...");
    }
}
