package dao;

import model.admin.Admin;
import model.user.User;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public void SaveAdmin(Admin admin) {
        String sql = "INSERT INTO admin (username, email, domain, password) VALUES (?, ?, ?, ?)";

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getEmail());
            statement.setString(4, admin.getDomain());
            statement.setString(3, admin.getPassword());

            ResultSet resultSet = statement.executeQuery();
        } catch(SQLException exception) {
            throw new RuntimeException("Não foi possível cadastrar o admin!");
        }
    }

    public Admin findByEmail(String email) {

        String sql = "SELECT * FROM admin WHERE email = ?";

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getLong("id"));
                admin.setUsername(resultSet.getString("username"));
                admin.setEmail(resultSet.getString("email"));
                admin.setDomain(resultSet.getString("domain"));
                admin.setPassword(resultSet.getString("password"));

                return admin;
            }

            return null;
        } catch(SQLException exception) {
            throw new RuntimeException("Erro ao buscar admin!" + exception);
        }
    }
}
