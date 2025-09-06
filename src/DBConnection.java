import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Method to get connection
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Test the connection
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Database connection successful!");
            } else {
                System.out.println("Database connection failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
