package service;

import dao.ProductDAO;
import exceptions.product.InvalidQuantityProduct;
import exceptions.product.InvalidValuePrice;
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
}
