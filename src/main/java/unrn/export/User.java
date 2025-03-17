package unrn.export;

public class User {

    private final String userName;
    private final String email;
    private final String pwd;

    public User(String userName, String pwd, String email) {
        this.userName = userName;
        this.pwd = pwd;
        this.email = email;
    }

    public String userName() {
        return this.userName;
    }

    public String email() {
        return this.email;
    }
}

