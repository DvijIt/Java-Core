package lesson36.repository;

import lesson36.model.User;
import lesson36.sessions.UserSession;

public class UserRepository {

    // считывание данных - считывание файла
    // обработка данных - маппинг данных


    public User registerUser(User user) {
        // save user to db (file)

        return null;
    }

    public void login(String name, String password) {

    }

    public void logout() {
        UserSession.setAuthorizedUser(null);
    }



}
