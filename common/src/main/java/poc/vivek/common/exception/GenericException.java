package poc.vivek.common.exception;

public class GenericException extends RuntimeException {
    private Throwable cause;
    private String message;

    GenericException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    GenericException(String message, Throwable cause) {
        super(message, cause);
        this.cause = cause;
        this.message = message;
    }

    public GenericException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
