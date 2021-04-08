package ServletTest;

import DBHandler.DBHandler;
import DataClasses.Choice;
import DataClasses.Credential;
import ServletBridge.ServletChoiceBridge;
import ServletBridge.ServletRegisterBridge;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;

class ServletTest {
    DBHandler dbHandler;

    @BeforeEach
    void setUp() throws SQLException {
        dbHandler = new DBHandler();
    }

    @AfterEach
    void tearDown() throws SQLException {
        dbHandler.closeConnection();
    }
    @Test
    public void servletChoiceBridge() throws SQLException {
        Assertions.assertTrue(ServletChoiceBridge.addChoice("-1", "A", "-1"));
        dbHandler.deleteLatest(Choice.tableName);
    }
    @Test
    public void servletChoiceBridgeBadFormat() throws SQLException {
        boolean status = ServletChoiceBridge.addChoice("aa", "A", "-1");
        if (status) {
            dbHandler.deleteLatest(Choice.tableName);
        }
        Assertions.assertFalse(status);
    }
    @Test
    public void servletRegisterBridge() throws SQLException {
        Assertions.assertTrue(ServletRegisterBridge.addCredential("_admin", "xxxx", "1"));
        dbHandler.deleteLatest(Credential.tableName);
    }
    @Test
    public void servletDoubleRegisterBridge() throws SQLException {
        Assertions.assertTrue(ServletRegisterBridge.addCredential("_admin", "xxxx", "1"));
        Assertions.assertFalse(ServletRegisterBridge.addCredential("_admin", "xxxx", "1"));
        dbHandler.deleteLatest(Credential.tableName);
    }


}