package exceptions;

import static exceptions.AuthErrors.*;

/**
 * @author annasavasteeva
 * @date 25.04.2026
 */
public class Authorization {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static boolean checkUserCredentials(String login, String password, String confirmPassword) {
        boolean isValid = false;
        try {
            isValid = isLoginValid(login) && isPasswordValid(password) && isPasswordConfirmed(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException ex) {
            printException(ex);
        }
        return isValid;
    }

    private static void printException(RuntimeException ex) {
        System.out.printf(ANSI_RED + """
                Exception is occurred: %s%n""" + ANSI_RESET, ex);
    }

    private static boolean isPasswordConfirmed(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.equals(confirmPassword)) throw new WrongPasswordException(PASS_NOT_CONFIRMED.getMessage());
        return true;
    }

    private static boolean isPasswordValid(String password) throws WrongPasswordException {
        if (!isLengthValid(password)) throw new WrongPasswordException(LENGTH_ERR.getMessage());
        if (isContainSpaces(password)) throw new WrongPasswordException(SPACES_ERR.getMessage());
        if (!isContainDigits(password)) throw new WrongPasswordException(CONTENT_ERR.getMessage());
        return true;
    }

    private static boolean isLoginValid(String login) throws WrongLoginException {
        if (!isLengthValid(login)) throw new WrongLoginException(LENGTH_ERR.getMessage());
        if (isContainSpaces(login)) throw new WrongLoginException(SPACES_ERR.getMessage());
        return true;
    }

    private static boolean isContainDigits(String credential) {
        return !credential.chars().allMatch(Character::isDigit) && credential.chars().anyMatch(Character::isDigit);
    }

    private static boolean isContainSpaces(String credential) {
        return credential.contains(" ");
    }

    private static boolean isLengthValid(String credential) {
        return credential.length() < 20;
    }
}
