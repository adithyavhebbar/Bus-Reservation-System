package hebbar.brs.services.exception.emptyvalue;

import hebbar.brs.DTO.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ValueNotPresentExceptionHandler {
    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Object> noSuchValueExceptionHandler(ValueNotPresentException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiError apiError = new ApiError(
                httpStatus,
                ZonedDateTime.now(),
                e.getMessage(),
                "The value provided is wrong. Please try with a new value"
        );
        return new ResponseEntity<>(apiError, httpStatus);
    }
}
