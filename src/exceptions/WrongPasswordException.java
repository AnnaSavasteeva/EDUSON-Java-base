package exceptions;

/**
 * @author annasavasteeva
 * @date 26.04.2026
 */
public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "WrongPasswordException{" +
                "message=" + getMessage() +
                "}";
    }
}
