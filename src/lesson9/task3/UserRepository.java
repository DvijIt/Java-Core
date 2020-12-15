package lesson9.task3;

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
}
