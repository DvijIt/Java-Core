package lesson9.User;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        String[] namesArray = new String[users.length];
        int index = 0;

        for (User user : users) {
            if (user != null) {
                namesArray[index] = user.getName();
                index++;
            }
        }
        return namesArray;
    }

    public long[] getUserIds() {
        long[] idsArray = new long[users.length];
        int index = 0;

        for (User user : users) {
            if (user != null) {
                idsArray[index] = user.getId();
                index++;
            }
        }
        return idsArray;
    }

    public String getUserNameById(long id) {
        for (User user : users) {
            if (id == user.getId())
                return user.getName();
        }
        return null;
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (name.equals(user.getName()))
                return user;
        }
        return null;
    }

    public User getUserById(long id) {
        for (User user : users) {
            if (id == user.getId())
                return user;
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (sessionId.equals(user.getSessionId()))
                return user;
        }
        return null;
    }
}
