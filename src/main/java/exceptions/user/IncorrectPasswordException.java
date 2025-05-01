package exceptions.user;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {
        super("Senha incorreta!");
    }
}
