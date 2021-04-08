package ServletBridge;

import DBHandler.DBHandler;
import DataClasses.Credential;

import java.sql.SQLException;

/**
 * The purpose of having a Bridge is such that we obfuscate the messy
 * details of inserting a Credential via the servlet.
 *
 * The servlet can thus just focus on moving data around w.r.t. the
 * user.
 */
public class ServletRegisterBridge {
    /**
     * @param username Username Parameter
     * @param password Password Parameter
     * @param isAdmin Is Admin Parameter
     * @return Whether if the registering is successful
     * @throws SQLException If something is wrong if the database
     */
    public static boolean addCredential(String username, String password, String isAdmin) throws SQLException {
        DBHandler dbHandler = new DBHandler();

        if (username.equals("null") || password.equals("null") || isAdmin.equals("null")) {
            dbHandler.closeConnection();
            return false;
        }

        // Boolean doesn't throw
        Credential c = new Credential(username, password, Boolean.parseBoolean(isAdmin));
        try {
            dbHandler.insertInto(c);
        } catch (SQLException exception) {
            dbHandler.closeConnection();
            return false;
        }
        dbHandler.closeConnection();
        return true;
    }
}
