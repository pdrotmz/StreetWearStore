package dao;

import exceptions.admin.InvalidEmailFormatException;
import model.admin.Admin;
import model.user.User;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public void SaveAdmin(Admin admin) {
        String sql = "INSERT INTO admin (username, email, password, domain) VALUES (?, ?, ?, ?)";

        try(Connection connection = ConnectionFactory.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getEmail());
            statement.setString(3, admin.getPassword());
            statement.setString(4, admin.getDomain());

            ResultSet resultSet = statement.executeQuery();
        } catch(SQLException exception) {
            throw new RuntimeException("Não foi possível cadastrar o admin!");
        }
    }

    public Admin findByEmail(String email) {

        String sql = "SELECT * FROM admin WHERE email = ?";

        try(Connection connection = ConnectionFactory.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getLong("id"));
                admin.setUsername(resultSet.getString("username"));
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                admin.setDomain(resultSet.getString("domain"));

                return admin;
            }

            return null;
        } catch(SQLException exception) {
            throw new InvalidEmailFormatException(email);
        }
    }
}
