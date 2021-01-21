package hebbar.brs.services.exception;

import org.springframework.http.HttpStatus;

public class IllegalValueException extends RuntimeException {
    private HttpStatus httpStatus;


    public IllegalValueException(String message) {
        super(message);
    }

    public IllegalValueException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public IllegalValueException setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }
}
