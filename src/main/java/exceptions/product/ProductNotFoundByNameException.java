package exceptions.product;

public class ProductNotFoundByNameException extends RuntimeException {
    public ProductNotFoundByNameException(String name) {
        super("O produto de nome: " + name + " não foi encontrado em nosso banco!");
    }
}
