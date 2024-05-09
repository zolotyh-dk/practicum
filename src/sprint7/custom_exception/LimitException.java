package sprint7.custom_exception;

public class LimitException extends RuntimeException {
    int attempts;

    public LimitException(String message, int attempts) {
        super(message);
        this.attempts = attempts;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + attempts;
    }
}