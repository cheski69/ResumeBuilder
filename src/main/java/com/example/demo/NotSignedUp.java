import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotSignedUp {

    public boolean database(String username, String password) {
        try {
            // Step 1: Establish connection to database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/resumebuilder", "root", "2317");

            // Step 2: Create a prepared statement
            String sql = "SELECT * FROM signup WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery();

            // Step 4: Process the result
            if (rs.next()) {
                return true; // User exists in the database
            }

            // Step 5: Close connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        }
        return false; // Default to false if user not found or error occurred
    }
}
