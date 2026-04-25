package exceptions;

/**
 * @author annasavasteeva
 * @date 25.04.2026
 */
public class WrongLoginException extends RuntimeException {

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "WrongLoginException{" +
                "message=" + getMessage() +
                "}";
    }
}
