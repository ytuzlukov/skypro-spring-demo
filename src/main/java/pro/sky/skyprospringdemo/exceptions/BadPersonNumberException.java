package pro.sky.skyprospringdemo.exceptions;

public class BadPersonNumberException extends RuntimeException {
    public BadPersonNumberException(String message) {
        super(message);
    }
}
