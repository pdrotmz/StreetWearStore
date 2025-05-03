package service;

import dao.ProductDAO;
import exceptions.product.InvalidQuantityProduct;
import exceptions.product.InvalidValuePrice;
import exceptions.product.ProductNotFoundException;
import model.product.Product;

import java.math.BigDecimal;
import java.util.List;


public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    public void registerProduct(Product product) {
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidValuePrice();
        }
        else if(product.getQuantity() < 0) {
            throw new InvalidQuantityProduct();
        }
        productDAO.saveProduct(product);
    }

    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

    public void findProductByName(String name) {
        Product product = new Product();
        if(product.getName().isEmpty()) {
            throw new ProductNotFoundException(name);
        }
        productDAO.findProductByName(name);
    }
}
