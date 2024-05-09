package sprint7.throws_exception;

public class IncorrectInputException extends Exception {
    public IncorrectInputException(String message) {
        super(message);
    }
}