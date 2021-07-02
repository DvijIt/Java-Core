package lesson36.controller;

import lesson36.service.UserService;
import lesson36.model.User;

public class UserController {

    private UserService userService = new UserService();

    public User registerUser(User user) {
        return userService.registerUser(user);
    }

    public void login(String name, String password) {
        userService.login(name, password);
    }

    public void logout() {
        userService.logout();
    }

}
