package model;

import java.sql.*;

// ---------- MODEL CLASS ----------
public class LoginModel {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // Constructor - Connect to the database
    public LoginModel() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database (Change DB name, username, password)
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/login_db", "admin", "sjcet123");
            System.out.println("Database Connected Successfully!");
        } catch (Exception e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
        }
    }

    // Validate login credentials using MySQL
    public boolean validateUser(String user, String pass) {
        boolean isValid = false;
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();

            if (rs.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            System.out.println("Error during validation: " + e.getMessage());
        }
        return isValid;
    }

    // Close database connection
    public void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}
