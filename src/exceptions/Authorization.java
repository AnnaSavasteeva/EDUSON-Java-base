package exceptions;

/**
 * @author annasavasteeva
 * @date 25.04.2026
 */
public class Authorization {

    public static boolean checkUserCredentials(String login, String password, String confirmPassword) {
        return isLoginValid(login) && isPasswordValid(password) && isPasswordConfirmed(password, confirmPassword);
    }

    private static boolean isPasswordConfirmed(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private static boolean isPasswordValid(String password) {
        return isCredentialValid(password)
                && !password.chars().allMatch(Character::isDigit)
                && password.chars().anyMatch(Character::isDigit);
    }

    private static boolean isLoginValid(String login) {
        return isCredentialValid(login);
    }

    private static boolean isCredentialValid(String credential) {
        return (credential.length() < 20) && !credential.matches(".*\\s.*");
    }
}
