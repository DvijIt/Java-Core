package lesson36.service;

import lesson36.model.User;
import lesson36.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) {
        // check business logic
        // 1. Вадидация
        // 2. Проверка на сущетсвующего юзера
        // 3. Формирование строки в базу
        // 4. Запись в файл

        // if logic is ok
        return userRepository.registerUser(user);
    }

    public void login(String name, String password) {
        userRepository.login(name, password);
    }

    public void logout() {
        userRepository.logout();
    }
}
