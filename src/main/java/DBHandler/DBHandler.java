package DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {

    Connection conn;

    public DBHandler() throws SQLException {
        openConnection();
    }
    public DBHandler(String db) throws SQLException {
        openConnection(db);
    }

    /**
     * Attempts to close connection with the default database
     */
    public void closeConnection() throws SQLException {
        conn.close();
    }

    /**
     * Attempts a connection with the db specified database
     */
    private void openConnection(String db) throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + db + "?" +
                        "allowPublicKeyRetrieval=true&" +
                        "useSSL=false&" +
                        "serverTimezone=UTC",
                "root",
                "xxxx");
    }

    /**
     * Attempts a connection with the default database
     */
    private void openConnection() throws SQLException {
        openConnection("clicker");
    }

    /**
     * @param sql A SQL acceptable String
     * @throws SQLException On Update Failure
     */
    public void executeUpdate(String sql) throws SQLException {
        try {
            Statement connStatement = conn.createStatement();

            System.out.print("Executing Statement: ");
            System.out.println(sql);

            connStatement.executeUpdate(sql);
        } catch (SQLException exc) {
            exc.printStackTrace();
            throw new SQLException("Failed to execute Update.");
        }
    }

    public void executeUpdate(String tableName,
                              List<String> colNames,
                              List<Object> values) throws SQLException {
        // .toString converts Lists into [a, b, ...]
        //                       we need (a, b, ...)
        // Hence we replace the [] to () on creation
        String colNamesStr = "";
        if (!colNames.isEmpty()) {
            colNamesStr = colNames.toString()
                    .replace("[", "(")
                    .replace("]", ")");
        }

        String valuesStr;
        valuesStr = values.toString()
                .replace("[", "(")
                .replace("]", ")");

        String sql =
                "INSERT INTO " +
                tableName + " " +
                (colNamesStr.isEmpty() ? "" : colNamesStr + " ") +
                "VALUES " +
                valuesStr + ";";

        executeUpdate(sql);
    }

    public void executeUpdate(String tableName,
                              List<Object> values) throws SQLException {
        List<String> col = new ArrayList<String>();
        executeUpdate(tableName, col, values);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement connStatement = conn.createStatement();

        System.out.print("Executing Statement: ");
        System.out.println(sql);

        return connStatement.executeQuery(sql);
    }

    public void insertInto(DBItem item) throws SQLException {
        executeUpdate(item.sqlInsertInto());
    }

    public void deleteLatest(String tableName) throws SQLException {
        executeUpdate("DELETE FROM " + tableName +" ORDER BY id DESC LIMIT 1\n");
    }

    /** Pretty Prints the Result Set
     *
     *  Reference: https://coderwall.com/p/609ppa/printing-the-result-of-resultset
     *
     * @param resultSet Result Set
     * @throws SQLException If resultset fails to decompose
     */
    public static void printResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = resultSet.getString(i);
                System.out.printf("%3.10s", columnValue);
                System.out.print(" (" + rsmd.getColumnName(i) + ")");
            }
            System.out.println("");
        }
    }


}
