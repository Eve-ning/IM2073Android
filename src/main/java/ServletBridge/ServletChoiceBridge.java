package ServletBridge;

import DBHandler.DBHandler;
import DataClasses.Choice;

import java.sql.SQLException;

/**
 * The purpose of having a Bridge is such that we obfuscate the messy
 * details of inserting a Choice via the servlet.
 *
 * The servlet can thus just focus on moving data around w.r.t. the
 * user.
 */
public class ServletChoiceBridge {
    /**
     * @param userId User Id Parameter, must be castable to Int
     * @param choice Choice Paramater
     * @param qNo Question Number Parameter, must be castable to Int
     * @return Whether if adding Choice was successful
     * @throws SQLException If something is wrong if the database
     */
    public static boolean addChoice(String userId, String choice, String qNo) throws SQLException {
        DBHandler dbHandler = new DBHandler();
        if (choice.equals("null")) {
            dbHandler.closeConnection();
            return false;
        }

        try {
            Choice c = new Choice(Integer.parseInt(userId), choice.toUpperCase(), Integer.parseInt(qNo));
            dbHandler.insertInto(c);
        } catch (NumberFormatException | SQLException exception) {
            dbHandler.closeConnection();
            return false;
        }
        dbHandler.closeConnection();
        return true;
    }
}
