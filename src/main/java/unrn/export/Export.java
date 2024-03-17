package unrn.export;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Export {
    private final List<User> users;

    public Export(List<User> users) {
        this.users = users;
    }

    public void export(FileWriter writer) throws IOException {
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
