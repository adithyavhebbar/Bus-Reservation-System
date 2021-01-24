package hebbar.brs.services.exception.postgresql;

public class DataIntegrityVoilationException extends RuntimeException {

    public DataIntegrityVoilationException(String message) {
        super(message);
    }

}
