package hebbar.brs.services.exception.postgresql;

import hebbar.brs.DTO.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class DataIntegrityVoilationExceptionHandler {

    @ExceptionHandler(value = {DataIntegrityVoilationException.class})
    public ResponseEntity<ApiError> handleDataIntegrityException(DataIntegrityVoilationException e) {
        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(),
                e.getMessage(),
                "Please try giving different code"
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
