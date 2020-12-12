package lesson7;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Deal deal1 = createOrder();
        Deal deal2 = createOrderAndCallMethods();
    }

    public static Deal createOrder() {
        Deal deal = new Deal(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        return deal;
    }

    public static Deal createOrderAndCallMethods() {
        Deal deal = new Deal(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        deal.confirmOrder();
        deal.checkPrice();
        deal.isValidType();
        return deal;
    }
}
