package unrn.export;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExportTest {
    @Test
    public void test01() throws IOException {
        var e = new Export(new Users().all());
        var writer = new StringWriter();
        e.export(writer);
        assertEquals("username, email\n" +
                        "user1,bla@email.com\n" +
                        "user2,bla2@email.com\n" +
                        "user3,bla3@email.com\n" +
                        "user4,bla4@email.com\n" +
                        "user5,bla5@email.com\n" +
                        "user6,bla6@email.com\n" +
                        "user7,bla7@email.com\n",
                writer.toString());
    }
}
