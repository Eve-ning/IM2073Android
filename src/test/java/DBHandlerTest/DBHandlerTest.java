package DBHandlerTest;

import DBHandler.DBHandler;
import DataClasses.Choice;
import DataClasses.Credential;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;

class DBHandlerTest {
    DBHandler dbHandler;

    @BeforeEach
    void setUp() throws SQLException {
        dbHandler = new DBHandler("clicker");
    }

    @AfterEach
    void tearDown() throws SQLException {
        dbHandler.closeConnection();
    }

    /** Tests Adding a singular Choice
     * @throws SQLException Shouldn't throw any exception
     */
    @Test
    void addChoice() throws SQLException {
        // We can allow the user to replace a choice by just keeping the record anyways
        // Instead of dropping the old record, we get the latest record.
        // The latest entry is defined by the latest id.
        Choice choice = new Choice(1, "A", 3);
        dbHandler.insertInto(choice);
        dbHandler.deleteLatest(Choice.tableName);
    }

    /** Tests Adding a singular Credential
     * @throws SQLException Throws exception if admin2 exists, or if deleteLatest fails
     */
    @Test
    void addCredential() throws SQLException {
        Credential credential = new Credential("admin2", "xxxx", true);
        dbHandler.insertInto(credential);
        dbHandler.deleteLatest(Credential.tableName);
    }

}