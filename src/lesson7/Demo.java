package lesson7;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Deal deal1 = createDeal();
        Deal deal2 = createDealAndCallMethods();
    }

    public static Deal createDeal() {
        Deal deal = new Deal(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        return deal;
    }

    public static Deal createDealAndCallMethods() {
        Deal deal = new Deal(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        deal.confirmOrder();
        deal.checkPrice();
        deal.isValidType();
        return deal;
    }
}
