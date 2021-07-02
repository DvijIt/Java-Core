package gromcode.main.lesson13;

import java.util.Arrays;

public class UserRepository {
    private User[] users = new User[10];

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        int index = 0;
        String[] userNames = new String[users.length];

        for (User user : users) {
            if (user != null) {
                userNames[index] = user.getName();
                index++;
            }
        }
        return userNames;
    }

    public long[] getUserIds() {
        int index = 0;
        long[] ids = new long[users.length];

        for (User user : users) {
            if (user != null) {
                ids[index] = user.getId();
                index++;
            }
        }
        return ids;
    }

    public String getUserNameById(long id) {
        if (users != null) {
            for (User user : users) {
                if (user != null && user.getId() == id)
                    return user.getName();
            }
        }
        return null;
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user != null && user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    //renamed from getUserById to findById + public -> private
    private User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && user.getSessionId().equals(sessionId)) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        if (user == null || findById(user.getId()) != null)
            return null;

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }

    public User update(User user) {
        if (user == null || findById(user.getId()) == null)
            return null;

        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(findById(id))) {
                users[i] = null;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}
