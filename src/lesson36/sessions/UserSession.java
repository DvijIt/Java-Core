package lesson36.sessions;

import lesson36.model.User;

public class UserSession {
    private static User authorizedUser;

    public static User getAuthorizedUser() {
        return authorizedUser;
    }

    public static void setAuthorizedUser(User authorizedUser) {
        UserSession.authorizedUser = authorizedUser;
    }
}
