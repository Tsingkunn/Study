package code.day010.homework.exception;

public class NameRepetitionException extends RuntimeException {
    public NameRepetitionException() {
    }

    public NameRepetitionException(String message) {
        super(message);
    }
}
