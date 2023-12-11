package repository;

import connection.JdbcConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public UserRepository() throws SQLException {
    }

    public int save(User user) throws SQLException {
        String add = "INSERT INTO users (firstName, lastName, userName, password) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1,user.getFirstName());
        preparedStatement.setString(2,user.getLastName());
        preparedStatement.setString(3,user.getUserName());
        preparedStatement.setString(4, user.getPassword());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public User login(String userName) throws SQLException {
        String loginQuery = "SELECT * FROM users WHERE userName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
        preparedStatement.setString(1,userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("userName"),
                    resultSet.getString("password")
            );
            return user;
        }
        else
            return null;
    }

    public int updateFirstName(String firstName) throws SQLException {
        String query = "UPDATE users SET firstName = ? WHERE id = 3";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,firstName);
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
