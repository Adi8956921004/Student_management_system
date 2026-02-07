package Student_Management;
import java.sql.*;

public class DButils {
    static Connection con;
    static Statement stmt;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/student_management"
                       + "?useSSL=false&serverTimezone=UTC";

            String user = "root";
            String password = "root";

            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            System.out.println("DB connected");

        } catch (Exception e) {
            System.out.println("DB connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void executeQuery(String query) {
        if (stmt == null) {
            System.out.println(" Statement not initialized");
            return;
        }
        try {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQueryGetResult(String query) {
        if (stmt == null) {
            System.out.println("Statement not initialized");
            return null;
        }
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
