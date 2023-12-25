package User;

public abstract class User {

    private static int idCounter = 0;
    private final int id;
    private final String login, password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        id = idCounter++;
    }
}
