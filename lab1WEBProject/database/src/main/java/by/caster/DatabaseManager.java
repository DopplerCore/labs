package by.caster;

import databaseUtils.ConnectionManager;

import java.sql.SQLException;

public class DatabaseManager {
    public static final boolean create() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS roles (
                    id serial PRIMARY KEY ,
                    name varchar(256)
                );
                """;
        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement()){
            statement.execute(sql);
        }
        return true;
    }

    public static final boolean drop() throws SQLException {
        String sql = """
                DROP TABLE IF EXISTS roles;
                """;
        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement()){
            statement.execute(sql);
        }
        return true;
    }
}
