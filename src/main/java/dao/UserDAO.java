package dao;

import model.user.User;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
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


    public void loginUser(Object o) {

    }
}
