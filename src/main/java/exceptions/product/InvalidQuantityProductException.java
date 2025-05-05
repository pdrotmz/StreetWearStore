package exceptions.product;

public class InvalidQuantityProductException extends RuntimeException {
  public InvalidQuantityProductException() {
    super("A quantity de produtos adicionados deve ser maior que zero.");
  }
}
