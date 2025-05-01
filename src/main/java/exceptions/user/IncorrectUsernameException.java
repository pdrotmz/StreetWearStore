package exceptions.user;

public class IncorrectUsernameException extends RuntimeException {
    public IncorrectUsernameException(String username) {
        super("O username: " + username + " não encontrado!");
    }
}
