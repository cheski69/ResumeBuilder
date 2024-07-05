import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpDb {
    
    public void database(String fname, String username, String email, String phonenum, String password) {
        try {
            // Step 1: Establish connection to database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/resumebuilder", "root", "2317");

            // Step 2: Create a prepared statement
            String sql = "INSERT INTO signup(fullname, username, email, phone, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fname);
            stmt.setString(2, username);
            stmt.setString(3, email);
            stmt.setString(4, phonenum); // Assuming phonenum is stored as a string in your database
            stmt.setString(5, password);

            // Step 3: Execute the query
            int count = stmt.executeUpdate();
            System.out.println("Rows affected: " + count);

            // Step 4: Close connections
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        }
    }
}
