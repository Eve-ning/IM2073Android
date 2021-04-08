package CredentialHandler;

import DBHandler.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CredentialHandler {

    public enum Status {
        FAIL,
        USER,
        ADMIN
    }

    /**
     * @param username Username as String
     * @param password Password as String
     * @return A CredentialHandler.Status of the login.
     * @throws SQLException
     */
    public static Status login(String username, String password) throws SQLException {

        DBHandler dbHandler = new DBHandler();
        ResultSet resultSet = dbHandler.executeQuery(
                "SELECT * FROM credentials " +
                    "WHERE username LIKE '" + username +
                    "' AND password LIKE '" + password + "';");

        if (!resultSet.isBeforeFirst()) {
            dbHandler.closeConnection();
            return Status.FAIL;
        } else {
            resultSet.next();
            String isAdmin = resultSet.getString("is_admin");
            dbHandler.closeConnection();
            if (isAdmin.equals("1")) {
                return Status.ADMIN;
            } else {
                return Status.USER;
            }
        }
    }
}
