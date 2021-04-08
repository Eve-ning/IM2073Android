package QuestionHandlerTest;

import DBHandler.DBHandler;
import DataClasses.Question;
import QuestionHandler.QuestionHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Map;

class QuestionHandlerTest {
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
    void addQuestion() throws SQLException {
        // We can allow the user to replace a choice by just keeping the record anyways
        // Instead of dropping the old record, we get the latest record.
        // The latest entry is defined by the latest id.
        Question qn = new Question(
                "What is 1+1?", "1", "2", "3", "4", "B"
        );
        dbHandler.insertInto(qn);
        dbHandler.deleteLatest(Question.tableName);
    }

    /**
     * Gets the next question
     * @throws SQLException
     */
    @Test
    void getQuestion() throws SQLException {

        Map<String, String> qn = QuestionHandler.getNextQuestion(1);

        System.out.println(qn.get("question"));
        System.out.println(qn.get("choiceA"));
        System.out.println(qn.get("choiceB"));
        System.out.println(qn.get("choiceC"));
        System.out.println(qn.get("choiceD"));
        System.out.println(qn.get("answer"));
    }

    /**
     * Gets any question with id > 999, which doesn't exist.
     * @throws SQLException
     */
    @Test
    void getMissingQuestion() throws SQLException {
        Map<String, String> qn = QuestionHandler.getNextQuestion(999);

        if (!qn.isEmpty()) {
            Assertions.fail();
        }
    }

}