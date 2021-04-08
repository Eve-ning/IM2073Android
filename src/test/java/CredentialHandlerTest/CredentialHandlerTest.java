package CredentialHandlerTest;

import CredentialHandler.CredentialHandler;
import DBHandler.DBHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class CredentialHandlerTest {
    DBHandler dbHandler;

    @BeforeEach
    void setUp() throws SQLException {
        dbHandler = new DBHandler("clicker");
    }

    @AfterEach
    void tearDown() throws SQLException {
        dbHandler.closeConnection();
    }

    /** Tests Admin Login
     * @throws SQLException Shouldn't throw any exception
     */
    @Test
    void loginAdmin() throws SQLException {
        CredentialHandler.Status status = CredentialHandler.login("admin", "xxxx");
        Assertions.assertEquals(CredentialHandler.Status.ADMIN, status);
        if (status == CredentialHandler.Status.ADMIN){

        }
    }

    /** Tests User Login
     * @throws SQLException Shouldn't throw any exception
     */
    @Test
    void loginUser() throws SQLException {
        CredentialHandler.Status status = CredentialHandler.login("alice", "password");
        Assertions.assertEquals(CredentialHandler.Status.USER, status);
    }

    /** Tests Failed Login
     * @throws SQLException Shouldn't throw any exception
     */
    @Test
    void loginFail() throws SQLException {
        CredentialHandler.Status status = CredentialHandler.login("asdf", "asdf");
        Assertions.assertEquals(CredentialHandler.Status.FAIL, status);
    }

}