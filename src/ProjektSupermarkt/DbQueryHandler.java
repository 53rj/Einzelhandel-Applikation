package ProjektSupermarkt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbQueryHandler {
    private Connection con;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int result = 0;

    public DbQueryHandler() {
        con = DB.connect();
    }

    public void registerUser(String username, String password) {

        String sql = "INSERT INTO user(name, password) VALUE(?,?)";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int loginUser(String username, String password) {
        String sql = "SELECT u.uid FROM user u WHERE name=? AND password=?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("uid");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
