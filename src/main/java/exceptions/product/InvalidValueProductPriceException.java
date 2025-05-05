package exceptions.product;

public class InvalidValueProductPriceException extends RuntimeException {
    public InvalidValueProductPriceException() {
        super("O preço do produto deve ser maior que zero.");
    }
}
