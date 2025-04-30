package service;

import dao.ProductDAO;
import model.product.Product;

import java.util.List;


public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    // TODO: Implements some logic to registerProduct

    public void registerProduct(Product product) {
        productDAO.saveProduct(product);
    }

    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }
}
