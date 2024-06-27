package ProjektSupermarkt;

import java.sql.*;

public class DbQueryHandler {
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public DbQueryHandler() {
        con = DB.connect();
    }

    public int registerUser(String username, String password) {
        // Execute a query
        String sql = "INSERT INTO user(name, password) VALUE('?','?')";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "username");
            preparedStatement.setString(1, "password");
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            int result = -1;
            return result;
        }
        int result = loginUser(username, password);
        return result;
    }

    public int loginUser(String username, String password) {
        String sql = "SELECT uid WHERE(name='?', password='?')";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "username");
            preparedStatement.setString(1, "password");
            resultSet = preparedStatement.executeQuery();

            // Process the results
            while (resultSet.next()) {
                if (username == resultSet.getString("name") && password == resultSet.getString("password")) {
                    return resultSet.getInt("uid");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int result = -1;
        return result;
    }
}
