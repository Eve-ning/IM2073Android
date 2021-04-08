package DataClasses;


import DBHandler.DBItem;

import java.util.Arrays;
import java.util.List;

public class Credential extends DBItem {
    private int     id = -1;
    private String  username;
    private String  password;
    private boolean isAdmin;
    public static String tableName = "credentials";

    public Credential(String username, String password, boolean is_admin) {
        this.username = username;
        this.password = password;
        this.isAdmin = is_admin;
    }

    public Credential(int id, String username, String password, boolean is_admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = is_admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    @Override
    public List<String> colNames() {
        return Arrays.asList("id", "username", "password", "is_admin");
    }

    @Override
    public String tableName() {
        return tableName;
    }

    @Override
    public String sqlInsertInto() {
        if (id < 0) {
            return sqlInsertInto(
                    colNames().subList(1, colNames().size()),
                    Arrays.asList(
                            "'" + username + "'",
                            "'" + password + "'",
                            Boolean.toString(isAdmin)
                    )
            );
        } else {
            return sqlInsertInto(
                    Arrays.asList(
                            Integer.toString(id),
                            "'" + username + "'",
                            "'" + password + "'",
                            Boolean.toString(isAdmin)
                    )
            );
        }
    }
}
