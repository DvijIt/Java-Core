package lesson10.task4;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonth;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonth) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonth = guaranteeMonth;
    }

    @Override
    void validateOrder() {
        if(validateCity(getShipToCity()) && validateCity(getShipFromCity())  && getBasePrice() >= 100 && getCustomerOwned().getGender().equals("Женский")) {
            setDateConfirmed(new Date());
        }
    }

    private boolean validateCity(String cityToValidate) {
        String[] validCitiesForOrder = {"Киев", "Львов"};
        for (String city : validCitiesForOrder) {
            if (city.equals(cityToValidate)) {
                return true;
            }
        }
        return false;
    }

    @Override
    void calculatePrice() {
        double totalPrice = getBasePrice() * calculateShippingPrice();
        setTotalPrice(totalPrice > 1000 ? totalPrice * 0.05d : totalPrice);
    }

    private double calculateShippingPrice() {
        String[] besideCities = {"Киев", "Одесса"};

        for (String city : besideCities) {
            if(getShipToCity().equals(city)) {
                return getBasePrice() * 0.1d;
            }
        }
        return getBasePrice() * 0.15d ;
    }
}
