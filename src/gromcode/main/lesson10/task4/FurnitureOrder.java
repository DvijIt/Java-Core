package gromcode.main.lesson10.task4;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    void validateOrder() {
        if(validateCity(getShipFromCity())  && getBasePrice() >= 500 && getCustomerOwned().getName() != "Тест") {
            setDateConfirmed(new Date());
        }
    }

    private boolean validateCity(String cityToValidate) {
        String[] validCitiesForOrder = {"Киев", "Одесса", "Днепр", "Харьков"};
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
        setTotalPrice(totalPrice);
    }

    private double calculateShippingPrice() {
        return getBasePrice() < 5000 ? getBasePrice() * 0.05d : getBasePrice() * 0.02d;
    }
}
