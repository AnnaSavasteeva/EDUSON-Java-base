package exceptions;

import java.util.HashMap;
import java.util.Map;

import static exceptions.Authorization.checkUserCredentials;

/**
 * @author annasavasteeva
 * @date 26.04.2026
 */
public class AuthorizationExceptionsApp {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String PASSWORD_CONFIRM = "passwordConfirmation";
    private static final String GOOD_LOGIN = "validLogin";
    private static final String GOOD_PASSWORD = "goodPassword26";

    public void runApp() {
        checkCredentialsAndPrintResult(getValidCredentials());
        checkCredentialsAndPrintResult(getCredentialsWithInvalidLoginLength());
    }

    private void checkCredentialsAndPrintResult(Map<String, String> creds) {
        System.out.println("--------------------");
        System.out.println("CREDENTIALS:");
        creds.forEach((key, value) -> System.out.println(key + " -> " + value));
        boolean isCredsOk = checkUserCredentials(creds.get(LOGIN), creds.get(PASSWORD), creds.get(PASSWORD_CONFIRM));
        System.out.printf(isCredsOk ? "---%nGOOD credentials%n" : "---%nBAD credentials%n");
        System.out.println("--------------------");
        System.out.println("--------------------");
    }

    private Map<String, String> getCredentialsWithInvalidLoginLength() {
        String invalidLogin = GOOD_LOGIN + "12345678920";
        return createCredentials(invalidLogin, GOOD_PASSWORD, GOOD_PASSWORD);
    }

    private Map<String, String> getValidCredentials() {
        return createCredentials(GOOD_LOGIN, GOOD_PASSWORD, GOOD_PASSWORD);
    }

    private Map<String, String> createCredentials(String login, String password, String passwordConfirm) {
        return new HashMap<>(){{
            put(LOGIN, login);
            put(PASSWORD, password);
            put(PASSWORD_CONFIRM, passwordConfirm);
        }};
    }
}
