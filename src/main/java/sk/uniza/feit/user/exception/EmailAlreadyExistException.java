package sk.uniza.feit.user.exception;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
