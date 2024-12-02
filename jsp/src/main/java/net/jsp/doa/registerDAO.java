package net.jsp.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
 // Ensure the package name is correct
import net.jsp.model.student;

public class registerDAO {
    private String url = "jdbc:mysql://localhost:3306/school";
    private String username = "root";
    private String password = "Student@123";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";

    // Method to load the database driver
    public void loadDriver() {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Consider using a logging framework here
        }
    }

    // Method to establish a connection to the database
    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework here
        }
        return con;
    }

    // Method to insert a student into the database
    public String insert(student s) {
        loadDriver(); // Load the database driver
        Connection con = getConnection(); // Get a connection to the database
        String sql = "INSERT INTO student (rollno, fname, lname, DOB) VALUES (?, ?, ?, ?)";
        String result = "Data Entered Successfully";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, s.getRollno());
            ps.setString(2, s.getFname());
            ps.setString(3, s.getLname());
            // Convert LocalDate to String in the desired format
            ps.setString(4, s.getDob().format(DateTimeFormatter.ISO_LOCAL_DATE));
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Data Not Entered Successfully: " + e.getMessage();
            e.printStackTrace(); // Consider using a logging framework here
        } finally {
            try {
                if (ps != null) {
                    ps.close(); // Close the PreparedStatement
                }
                if (con != null) {
                    con.close(); // Close the connection
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Consider using a logging framework here
            }
        }
        return result;
    }
}