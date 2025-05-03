package exceptions.product;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(String message) {
    super("O produto: " + message + " não foi encontrado!");
  }
}
