package lesson7;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Deal deal1 = createDealAndCallMethods();
    }

    public static void createDeal() {
        Deal deal = new Deal(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
    }

    public static Deal createDealAndCallMethods() {
        Deal deal = new Deal(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        deal.confirmOrder();
        deal.checkPrice();
        deal.isValidType();
        return deal;
    }
}
