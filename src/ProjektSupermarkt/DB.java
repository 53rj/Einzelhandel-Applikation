package ProjektSupermarkt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private static final String URL = "jdbc:mysql://localhost:3306/kauflanddb";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final Logger LOGGER = Logger.getLogger(DB.class.getName());

    public static Connection connect() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            LOGGER.info("Connection established successfully!");
            return connection;
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "MySQL JDBC Driver not found.", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error while establishing the connection.", e);
        }
        return null;
    }

    public static void main(String[] args) {
        try (Connection connection = DB.connect()) {
            if (connection != null) {
                LOGGER.info("Database connection established successfully.");
            } else {
                LOGGER.severe("Error while establishing the database connection.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error while closing the connection.", e);
        }
    }
}
