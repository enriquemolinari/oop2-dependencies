package unrn.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Users {
    public List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public void export() {
        File aFile = new File("/home/enrique/export-users.txt");
        try(FileWriter writer = new FileWriter(aFile)){
            writer.write(this.toCSV());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append("username, email").append(System.lineSeparator());
        for (User user : users) {
            sb.append(user.userName()).append(",").append(user.email()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
