package exceptions.user;

public class InvalidPasswordFormat extends RuntimeException {
    public InvalidPasswordFormat() {
        super("A senha precisa ter mais de 8 caracteres");
    }
}
