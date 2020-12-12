package lesson6.task4;

import java.util.Date;

public class Deal {
    private long id;
    private int price;
    private Date dateCreated;
    private boolean isConfirmed;
    private Date dateConfirmed;
    private String city;
    private String country;
    private String type;

    public Deal() {}

    public Deal(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }


    public void confirmOrder(boolean status) {
        isConfirmed = status;
        dateConfirmed = new Date();
    }

    public boolean checkPrice() {
        if(price > 1000) {
            return true;
        }

        return false;
    }

    public boolean isValidType() {
        if (type.equals("Sale")) {
            return true;
        }



        return false;
    }
}
