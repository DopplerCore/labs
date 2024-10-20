package org.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.example.models.User;

public class UserDao implements Dao<Integer, User>{
    
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "77885449";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<User> getAll() {
        List<User> users = new ArrayList<User>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setBio(resultSet.getString("bio"));
                user.setAdress(resultSet.getString("adress"));
                user.setPhone(resultSet.getString("phone"));

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getById(Integer id) {
        User user = null;

        try {
            String SQL = "SELECT * FROM Users WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setBio(resultSet.getString("bio"));
            user.setAdress(resultSet.getString("adress"));
            user.setPhone(resultSet.getString("phone"));
        } catch (SQLException e) {
            e.printStackTrace();
        }  

        return user;
    }

    public void save(User user) {
        try {
            String SQL = "INSERT INTO Users VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getBio());
            preparedStatement.setString(4, user.getAdress());
            preparedStatement.setString(5, user.getPhone());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Integer id, User updatedUser) {
        try {
            String SQL = "UPDATE Users SET id=?,name=?,bio=?,adress=?,phone=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, updatedUser.getId());
            preparedStatement.setString(2, updatedUser.getName());
            preparedStatement.setString(3, updatedUser.getBio());
            preparedStatement.setString(4, updatedUser.getAdress());
            preparedStatement.setString(5, updatedUser.getPhone());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            String SQL = "DELETE FROM Users WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
