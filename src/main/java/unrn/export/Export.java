package unrn.export;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Export {
    private final List<User> users;

    public Export(List<User> users) {
        this.users = users;
    }

    public void export(Writer writer) throws IOException {
        try {
            writer.write("username, email" + System.lineSeparator());
            for (User user : users) {
                writer.write(user.userName() + "," + user.email() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
