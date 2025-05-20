package at.technikum.todoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class TodoAlreadyExistsException extends RuntimeException {

    public TodoAlreadyExistsException() {
    }

    public TodoAlreadyExistsException(String message) {
        super(message);
    }

    public TodoAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TodoAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public TodoAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
