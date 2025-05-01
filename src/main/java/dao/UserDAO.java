package dao;

import model.user.User;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO{

    public void saveUser(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");

        } catch(SQLException exception) {
            throw new RuntimeException("Erro ao cadastrar usuário!");
        }
    }

    public User findById(long id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));

                return user;
            }
            return null;

        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao buscar usuário por id");
        }
    }

    public User findBYUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                // user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }
            return null;
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao buscar o usuário!", exception);
        }
    }

}
