package DataClasses;
import DBHandler.DBItem;

import java.util.Arrays;
import java.util.List;

public class Question extends DBItem {

    private int id;
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String answer;
    public static String tableName = "questions";

    public Question(int id, String question, String choiceA, String choiceB, String choiceC, String choiceD,
                    String answer) {
        this.id = id;
        this.question = question;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.answer = answer;
    }

    public Question(String question, String choiceA, String choiceB, String choiceC, String choiceD, String answer) {
        this.question = question;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public List<String> colNames() {
        return Arrays.asList(
                "id",
                "question",
                "choiceA",
                "choiceB",
                "choiceC",
                "choiceD",
                "answer");
    }

    @Override
    public String tableName() {
        return tableName;
    }

    @Override
    public String sqlInsertInto() {
        if (id < 0) {
            return sqlInsertInto(
                    colNames().subList(1, colNames().size()),
                    Arrays.asList(
                            "'" + question + "'",
                            "'" + choiceA + "'",
                            "'" + choiceB + "'",
                            "'" + choiceC + "'",
                            "'" + choiceD + "'",
                            "'" + answer + "'"
                    )
            );
        } else {
            return sqlInsertInto(
                    Arrays.asList(
                            Integer.toString(id),
                            "'" + question + "'",
                            "'" + choiceA + "'",
                            "'" + choiceB + "'",
                            "'" + choiceC + "'",
                            "'" + choiceD + "'",
                            "'" + answer + "'"
                    )
            );
        }
    }

}
