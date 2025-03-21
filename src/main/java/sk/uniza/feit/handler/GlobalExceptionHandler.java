package sk.uniza.feit.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sk.uniza.feit.user.exception.EmailAlreadyExistException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> handleEmailAlreadyExistException(EmailAlreadyExistException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 400, System.currentTimeMillis());
        return ResponseEntity.badRequest().body(errorMessage);
    }

}
