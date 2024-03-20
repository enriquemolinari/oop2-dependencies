package unrn.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Export {
    public void export() throws IOException {
        var users = new Users().all();
        File aFile = new File("/home/enrique/export-users.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(aFile);
            writer.write("username, email" + System.lineSeparator());
            for (User user : users) {
                writer.write(user.userName() + "," + user.email() + System.lineSeparator());
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
