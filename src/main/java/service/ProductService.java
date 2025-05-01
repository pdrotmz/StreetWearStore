package service;

import dao.ProductDAO;
import exceptions.product.InvalidValuePrice;
import model.product.Product;

import java.math.BigDecimal;
import java.util.List;


public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    // TODO: Implements some logic to registerProduct

    public void registerProduct(Product product) {
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidValuePrice();
        }
        productDAO.saveProduct(product);
    }

    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }
}
