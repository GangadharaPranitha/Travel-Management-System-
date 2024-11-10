package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load the JDBC driver (modify with your specific driver if needed)
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            // Establish the connection to your database (update with your database URL, username, and password)
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "Bunny#23");
            
            // Create a statement object to execute queries
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to execute update queries (like INSERT, UPDATE, DELETE)
    public void executeUpdate(String query) throws Exception {
        s.executeUpdate(query); // This executes the given update query
    }

    // Method to execute select queries (like SELECT)
    public ResultSet executeQuery(String query) throws Exception {
        return (ResultSet) s.executeQuery(query); // This executes the given select query and returns a ResultSet
    }

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
