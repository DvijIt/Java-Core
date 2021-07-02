package gromcode.main.lesson27.hw2.UserRepository;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<String> getUserNames() {
        ArrayList<String> namesArray = new ArrayList<>();

        for (User user : users) {
            namesArray.add(user.getName());
        }

        return namesArray;
    }

    public ArrayList<Long> getUserIds() {
        ArrayList<Long> idsArray = new ArrayList<>();

        for (User user : users) {
            idsArray.add(user.getId());
        }
        return idsArray;
    }

    public String getUserNameById(long id) {
        for (User user : users) {
            if (id == user.getId()) {
                return user.getName();
            }
        }
        return null;
    }

    public User getUserByName(String name) throws Exception {
        for (User user : users) {
            if (name.equals(user.getName())) {
                return user;
            }
        }
        throw new Exception("User is not defined by Name");
    }

    private User findById(long id) throws Exception {
        for (User user : users) {
            if (id == user.getId()) {
                return user;
            }
        }
        throw new Exception("User is not defined by Id");
    }

    public User getUserBySessionId(String sessionId) throws Exception {
        for (User user : users) {
            if (sessionId.equals(user.getSessionId())) {
                return user;
            }

        }
        throw new Exception("User is not defined by SessionId");
    }

    public User save(User user) throws Exception {
        if (user == null) {
            throw new Exception("Can not save null as user");
        }

        if (users.contains(user)) {
            throw new Exception("User with id " + user.getId() + " is already exists.");
        }

        users.add(user);
        return user;
    }

    public User update(User user) throws Exception {
        if (user == null) {
            throw new Exception("Can not update, user is null");
        }

        if (!users.contains(user)) {
            throw new Exception("User is not defined");
        }

        int userIndex = users.indexOf(user);
        users.set(userIndex, user);

        return users.get(userIndex);
    }

    public void delete(long id) throws Exception {
        users.remove(findById(id));

        throw new Exception("Unexpected error");
    }

}
