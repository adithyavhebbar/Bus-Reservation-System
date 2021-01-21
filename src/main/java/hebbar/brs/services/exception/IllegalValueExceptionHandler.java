package hebbar.brs.services.exception;

import hebbar.brs.DTO.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class IllegalValueExceptionHandler {

    @ExceptionHandler(value = {IllegalValueException.class})
    public ResponseEntity<Object> handleApiExceptionHandler(IllegalValueException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiError apiError = new ApiError(badRequest,
                ZonedDateTime.now(),
                e.getMessage(),
                "Please provide a valid value");
        return new ResponseEntity<>(apiError, badRequest);
    }
}
