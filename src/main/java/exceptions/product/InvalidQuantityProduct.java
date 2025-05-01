package exceptions.product;

public class InvalidQuantityProduct extends RuntimeException {
  public InvalidQuantityProduct() {
    super("A quantity de produtos adicionados deve ser maior que zero.");
  }
}
