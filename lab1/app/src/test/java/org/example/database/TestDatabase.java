package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;

public class TestDatabase {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE poks (id INT, name VARCHAR, bio VARCHAR, adress VARCHAR, phone VARCHAR)");
            statement.execute("INSERT INTO poks (id, name, bio, adress, phone) VALUES (1, 'John Doe', 'John Doe', 'John Doe', 'John Doe')");
            System.out.println("Table created and data inserted!");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM poks");
            resultSet.next();
            Assertions.assertEquals("John Doe", resultSet.getString(2));
            System.out.println("ans :");
            System.out.println(resultSet.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
