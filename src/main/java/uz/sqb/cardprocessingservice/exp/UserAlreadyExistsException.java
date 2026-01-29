package uz.sqb.cardprocessingservice.exp;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String username) {
        super("User " + username + " already exists");
    }
}
