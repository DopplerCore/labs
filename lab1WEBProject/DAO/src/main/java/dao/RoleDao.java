package dao;

import databaseUtils.ConnectionManager;
import dto.RoleFilter;
import entity.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RoleDao implements Dao<Long, Role> {

    private static final Connection connection;

    static {
        connection = ConnectionManager.get();
    }

    @Override
    public Role getById(Long id) {
        Role role = null;
        try {
            String SQL = "SELECT * FROM roles WHERE id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            role = new Role();
            role.setId(resultSet.getLong("id"));
            role.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles = new ArrayList<Role>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM roles;";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getString("name"),
                        resultSet.getLong("id")
                );
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public List<Role> getAll(RoleFilter roleFilter) {
        List<Object> parameters = new ArrayList<>();
        List<String> whereSQL = new ArrayList<>();
        if(roleFilter.name() != null) {
            parameters.add(roleFilter.name());
            whereSQL.add("name = ?");
        }
        parameters.add(roleFilter.limit());
        parameters.add(roleFilter.offset());
        var WSQL = whereSQL.stream().collect(Collectors.joining(
                " AND ",
                " WHERE ",
                " LIMIT ? OFFSET ? "
        ));
        List<Role> roles = new ArrayList<Role>();
        try {
            String SQL = "SELECT * FROM roles" + WSQL;
            var statement = connection.prepareStatement(SQL);
            for(int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getString("name"),
                        resultSet.getLong("id")
                );
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public void save(Role role) {
        try {
            String SQL = "INSERT INTO roles VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, role.getId());
            preparedStatement.setString(2, role.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, Role updatedRole) {
        try {
            String SQL = "UPDATE roles SET id=?,name=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, updatedRole.getId());
            preparedStatement.setString(2, updatedRole.getName());
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String SQL = "DELETE FROM roles WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
