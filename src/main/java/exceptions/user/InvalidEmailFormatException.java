package exceptions.user;

public class InvalidEmailFormatException extends RuntimeException {
    public InvalidEmailFormatException(String message) {
        super("O email inserido: " + message + ", não contém @");
    }
}
