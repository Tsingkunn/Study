package code.day010.exception;

public class NameRepetitionException extends RuntimeException {
    public NameRepetitionException() {
    }

    public NameRepetitionException(String message) {
        super(message);
    }
}
