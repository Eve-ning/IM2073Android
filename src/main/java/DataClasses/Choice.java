package DataClasses;
import DBHandler.DBItem;

import java.util.Arrays;
import java.util.List;

public class Choice extends DBItem {

    private int id;
    private int userId;
    private String choice;
    private int qNo;
    public static String tableName = "choices";

    public Choice(int id, int userId, String choice, int qNo) {
        this.id = id;
        this.userId = userId;
        this.choice = choice;
        this.qNo = qNo;
    }

    public Choice(int userId, String choice, int qNo) {
        this.userId = userId;
        this.choice = choice;
        this.qNo = qNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public int getQNo() {
        return qNo;
    }

    public void setQNo(int qNo) {
        this.qNo = qNo;
    }

    @Override
    public List<String> colNames() {
        return Arrays.asList("id", "user_id", "choice", "q_no");
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
                            Integer.toString(userId),
                            "'" + choice + "'",
                            Integer.toString(qNo)
                    )
            );
        } else {
            return sqlInsertInto(
                    Arrays.asList(
                            Integer.toString(id),
                            Integer.toString(userId),
                            "'" + choice + "'",
                            Integer.toString(qNo)
                    )
            );
        }
    }

}
