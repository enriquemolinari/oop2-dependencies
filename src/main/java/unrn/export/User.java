package unrn.export;

public class User {

    private String userName;
    private String email;
    private String pwd;

    private User(String userName, String pwd, String email) {
        this.userName = userName;
        this.pwd = pwd;
        this.email = email;
    }

    public static User userAs(String userName, String pwd, String email) {
        return new User(userName, pwd, email);
    }

    public String userName() {
        return this.userName;
    }

    public String email() {
        return this.email;
    }
}

