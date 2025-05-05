package service;

import dao.ProductDAO;
import exceptions.product.InvalidQuantityProductException;
import exceptions.product.InvalidValueProductPriceException;
import exceptions.product.ProductNotFoundByNameException;
import model.product.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    public void registerProduct(Product product) {
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidValueProductPriceException();
        }
        else if(product.getQuantity() < 0) {
            throw new InvalidQuantityProductException();
        }
        productDAO.saveProduct(product);
    }

    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

    public void findProductByName(String name) {
        List<Product> foundProducts = productDAO.findProductByName(name);

        if(foundProducts.isEmpty()) {
            throw new ProductNotFoundByNameException(name);
        }

        for(Product product : foundProducts) {
            System.out.println("------------");
            System.out.println("ID: " + product.getId());
            System.out.println("Nome: " + product.getName());
            System.out.println("Descrição: " + product.getDescription());
            System.out.println("Preço: " + product.getPrice());
            System.out.println("Quantidade: " + product.getQuantity());
            System.out.println("------------");
        }
    }

}
