package StatHandlerTest;

import DBHandler.DBHandler;
import DBHandler.DBQueries;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

class StatHandlerTest {
    DBHandler dbHandler;

    @BeforeEach
    void setUp() throws SQLException {
        dbHandler = new DBHandler("clicker");
    }

    @AfterEach
    void tearDown() throws SQLException {
        dbHandler.closeConnection();
    }

    /** Tests the counted stats
     * @throws SQLException Shouldn't throw any exception
     */
    @Test
    void countStats() throws SQLException {
        ResultSet resultSet = dbHandler.executeQuery(DBQueries.COUNT_STATS);
        DBHandler.printResultSet(resultSet);
    }

}