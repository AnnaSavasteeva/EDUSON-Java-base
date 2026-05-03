package exceptions;

/**
 * @author annasavasteeva
 * @date 25.04.2026
 */

public enum AuthErrors {

    LENGTH_ERR("Length must be less than 20 characters"),
    SPACES_ERR("Spaces are not allowed"),
    CONTENT_ERR("Must contain at least one digit and letter"),
    PASS_NOT_CONFIRMED("NOT EQUAL PASSWORDS");

    AuthErrors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private final String message;
}
