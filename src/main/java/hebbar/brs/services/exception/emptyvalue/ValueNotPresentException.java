package hebbar.brs.services.exception.emptyvalue;

public class ValueNotPresentException extends RuntimeException{
    public ValueNotPresentException(String message) {
        super(message);
    }

    public ValueNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}
