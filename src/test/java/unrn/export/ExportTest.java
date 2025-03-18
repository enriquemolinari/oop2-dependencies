package unrn.export;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ExportTest {
    @Test
    public void test01() {
        var users = new Users(listaDeUsuarios());
        users.export();
        //¿ assert ?
//        assertEquals("""
//                        username, email
//                        user1,bla@email.com
//                        user2,bla2@email.com
//                        user3,bla3@email.com
//                        user4,bla4@email.com
//                        user5,bla5@email.com
//                        user6,bla6@email.com
//                        user7,bla7@email.com
//                        """,
//                ???);
    }

    private static List<User> listaDeUsuarios() {
        return List.of(new User("user1", "pwd1", "bla@email.com"),
                new User("user2", "pwd2", "bla2@email.com"),
                new User("user3", "pwd3", "bla3@email.com"),
                new User("user4", "pwd4", "bla4@email.com"),
                new User("user5", "pwd5", "bla5@email.com"),
                new User("user6", "pwd6", "bla6@email.com"),
                new User("user7", "pwd7", "bla7@email.com")
        );
    }
}
