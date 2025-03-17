package unrn.export;

import java.util.List;

public class Users {
    public List<User> users;
    private Exportador exportador;

    public Users(List<User> users, Exportador exportador) {
        this.users = users;
        this.exportador = exportador;
    }

    public void export() {
        this.exportador.export(this.toCSV());
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
