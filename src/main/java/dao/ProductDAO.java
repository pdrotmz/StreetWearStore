package dao;

import model.product.Product;

import java.util.List;
import java.util.Optional;

public class ProductDAO implements DAO<Product>{


    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Optional<Product> findProductById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return Optional.empty();
    }

    @Override
    public void deleteProductById(long id) {

    }
}
