package DBHandler;

public class DBQueries {
//    public static String FULL_STATS =
//            "SELECT a.* FROM choices a " +
//            "INNER JOIN " +
//            "(SELECT user_id, max(id) AS maxid FROM choices GROUP BY user_id, q_no) AS b " +
//            "ON a.id = b.maxid;";

    public static String COUNT_STATS =
            "SELECT a.q_no, a.choice, b.count FROM choices a " +
            "INNER JOIN " +
            "(SELECT count(id) As count," +
                    "max(id) AS maxid FROM choices GROUP BY q_no, choice) AS b " +
            "ON a.id = b.maxid " +
            "ORDER BY a.q_no, a.choice";
}
