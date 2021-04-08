package QuestionHandler;

import DBHandler.DBHandler;
import DataClasses.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class QuestionHandler {

    public static void setNextQuestion(
            String question,
            String choiceA,
            String choiceB,
            String choiceC,
            String choiceD,
            String answer
    ) throws SQLException {

        DBHandler dbHandler = new DBHandler();
        Question qn = new Question(
                question, choiceA, choiceB, choiceC, choiceD, answer
        );

        dbHandler.insertInto(qn);
        dbHandler.closeConnection();
    }

    /**
     * @param id The previous id of next question to find. i.e. id+1, id+2, ...
     * @return A Map of {"question", "choiceA", "choiceB", "choiceC", "choiceD", "answer"}
     * @throws SQLException
     */
    public static Map<String, String> getNextQuestion(int id) throws SQLException {

        DBHandler dbHandler = new DBHandler();
        ResultSet resultSet = dbHandler.executeQuery("SELECT * FROM questions" +
                " WHERE id > " + id + " LIMIT 1;");

        Map<String, String> map = new HashMap<String, String>();
        if (!resultSet.isBeforeFirst()) {
            dbHandler.closeConnection();
            return map;
        }
        resultSet.next();
        map.put("question", resultSet.getString("question"));
        map.put("choiceA", resultSet.getString("choiceA"));
        map.put("choiceB", resultSet.getString("choiceB"));
        map.put("choiceC", resultSet.getString("choiceC"));
        map.put("choiceD", resultSet.getString("choiceD"));
        map.put("answer", resultSet.getString("answer"));

        return map;
    }


}
