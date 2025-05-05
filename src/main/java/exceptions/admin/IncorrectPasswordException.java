package exceptions.admin;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {
        super("Senha incorreta!");
    }
}
