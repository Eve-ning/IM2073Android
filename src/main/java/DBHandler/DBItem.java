package DBHandler;

import java.util.List;

public abstract class DBItem {
    /**
     * @return Returns the Table Name as a String
     */
    public abstract String tableName();

    /**
     * @return Returns a list of column names, exact to SQL Table
     */
    public abstract List<String> colNames();

    /**
     * @return Returns an executable SQL String that Inserts into table
     */
    public abstract String sqlInsertInto();


    /** Creates an sqlInsertInto acceptable SQL String
     * @param cols Column names
     * @param values Values
     */
    protected String sqlInsertInto(List<String> cols, List<String> values) {
        return "INSERT INTO " +
                tableName() + " " +
                cols.toString()
                    .replace("[", "(")
                    .replace("]", ")") +
                " VALUES " +
                values.toString()
                      .replace("[", "(")
                      .replace("]", ")") +
                ";";
    }

    /** Creates an sqlInsertInto acceptable SQL String
     * @param values Values
     */
    protected String sqlInsertInto(List<String> values) {
        return "INSERT INTO " +
                tableName() +
                " VALUES " +
                values.toString()
                      .replace("[", "(")
                      .replace("]", ")") +
                ";";
    }
}