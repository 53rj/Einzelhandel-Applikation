package ProjektSupermarkt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String URL = "jdbc:mysql://localhost:3306/deinedatenbank"; // Ersetze "deinedatenbank" durch den Namen deiner Datenbank
    private static final String USER = "root"; // Ersetze "root" durch deinen MySQL-Benutzernamen
    private static final String PASSWORD = ""; // Ersetze "" durch dein MySQL-Passwort, falls vorhanden

    public static Connection connect() {
        Connection connection = null;
        try {
            // Laden des MySQL JDBC-Treibers
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Verbindung zur Datenbank herstellen
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Verbindung erfolgreich!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC-Treiber nicht gefunden.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Fehler beim Herstellen der Verbindung.");
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        // Testen der Verbindung
        Connection connection = DB.connect();
        if (connection != null) {
            System.out.println("Datenbankverbindung erfolgreich hergestellt.");
        } else {
            System.out.println("Fehler beim Herstellen der Datenbankverbindung.");
        }
    }
}
