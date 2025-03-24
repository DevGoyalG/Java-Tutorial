import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {

    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // Replace with your database URL
        String username = "root"; // Your MySQL username
        String password = "manager"; // Your MySQL password

        // Create a connection object
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database successfully!");

            // Create a statement object
            Statement statement = connection.createStatement();

            // Sample query
            String query = "SELECT * FROM my_table"; // Replace 'my_table' with your table name
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result
            while (resultSet.next()) {
                // Assuming your table has columns 'id' and 'name'
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
