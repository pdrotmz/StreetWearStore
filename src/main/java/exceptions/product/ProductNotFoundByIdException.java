package exceptions.product;

public class ProductNotFoundByIdException extends RuntimeException {
    public ProductNotFoundByIdException(Long id) {
        super("O produto com id: " + id + "não foi encontrado em nosso banco!");
    }
}
