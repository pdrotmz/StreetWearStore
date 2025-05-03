package dao;

import exceptions.product.ProductNotFoundException;
import model.product.Product;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO{

    public void saveProduct(Product product) {
        String sql = "INSERT INTO product (name, description, price, quantity) VALUES (?, ?, ?, ?)";

        try(Connection connection = ConnectionFactory.getInstance();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());

            stmt.executeUpdate();

            System.out.println("Produto salvo com sucesso!");
        } catch(SQLException exception) {
            throw new RuntimeException("Erro ao salvar produto", exception);
        }
    }


    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();
        String sql =  "SELECT * FROM product";

        try (Connection connection = ConnectionFactory.getInstance();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            while(resultSet.next()) {
                Product product = new Product(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getBigDecimal("price"),
                    resultSet.getInt("quantity")
                );
                products.add(product);
            }

        } catch(SQLException exception) {
            throw new RuntimeException("Erro ao lista os produtos", exception);
        }

        return products;
    }

    public Optional<Product> findProductByName(String name) {
        String sql = "SELECT * FROM product p WHERE p.name = ?";

        try(Connection connection = ConnectionFactory.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString("name"));

                return Optional.of(product);
            }


        } catch(SQLException exception) {
            throw new ProductNotFoundException(name);
        }
        return Optional.empty();
    }

    public Optional<Product> findProductById(long id) {
        return Optional.empty();
    }

    public void deleteProductById(long id) {

    }
}
