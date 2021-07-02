package lesson36.model;

public class Hotel {
    private Long id;
    private String name;
    private String country;
    private String city;

    public Hotel(Long id, String name, String country, String city, String street) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    private String street;
}
