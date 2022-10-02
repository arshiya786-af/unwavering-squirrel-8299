import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {
    private final static String className = "com.mysql.jdbc.Driver";
    private final static String url =  "jdbc:mysql://localhost:3306/coursemanagement";
    private final static String user = "root";
    private final static String password = "root";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }
}