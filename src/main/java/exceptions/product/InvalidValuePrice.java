package exceptions.product;

public class InvalidValuePrice extends RuntimeException {
    public InvalidValuePrice() {
        super("O preço do produto deve ser maior que zero.");
    }
}
