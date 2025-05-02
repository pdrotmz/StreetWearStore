package dao;

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

    public Optional<Product> findProductById(long id) {
        return Optional.empty();
    }

    public Optional<Product> findProductByName(String name) {
        return Optional.empty();
    }

    public void deleteProductById(long id) {

    }
}
