package sk.uniza.feit.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sk.uniza.feit.blog.domain.AlreadyExistEntity;
import sk.uniza.feit.user.exception.EmailAlreadyExistException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> handleEmailAlreadyExistException(EmailAlreadyExistException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 400, System.currentTimeMillis());
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(EntityNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404, System.currentTimeMillis());
        return ResponseEntity.status(404).body(errorMessage);
    }

    @ExceptionHandler(AlreadyExistEntity.class)
    public ResponseEntity<ErrorMessage> handleAlreadyExistEntity(AlreadyExistEntity e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 400, System.currentTimeMillis());
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
