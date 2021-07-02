package lesson36.model;

import lesson36.utils.UserType;

public class User {
    private Long id;
    private String userName;
    private String password;
    private String country;

    public User(Long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    private UserType userType;
}
