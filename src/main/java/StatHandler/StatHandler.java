package StatHandler;

import DBHandler.DBHandler;
import DBHandler.DBQueries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatHandler {

    public static ResultSet getStatistics() throws SQLException {

        DBHandler dbHandler = new DBHandler();
        ResultSet resultSet = dbHandler.executeQuery(
                DBQueries.COUNT_STATS
        );
        dbHandler.closeConnection();
        return resultSet;
    }

}
