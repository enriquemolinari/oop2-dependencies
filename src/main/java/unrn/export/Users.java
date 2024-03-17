package unrn.export;

import java.util.List;

import static unrn.export.User.userAs;

public class Users {
    public List<User> all() {
        return List.of(userAs("user1", "pwd1", "bla@email.com"),
                userAs("user2", "pwd2", "bla2@email.com"),
                userAs("user3", "pwd3", "bla3@email.com"),
                userAs("user4", "pwd4", "bla4@email.com"),
                userAs("user5", "pwd5", "bla5@email.com"),
                userAs("user6", "pwd6", "bla6@email.com"),
                userAs("user7", "pwd7", "bla7@email.com")
        );
    }
}
