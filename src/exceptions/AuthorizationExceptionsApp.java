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

    public void runApp() {
        checkCredentialsAndPrintResult(getValidCredentials());
    }

    private void checkCredentialsAndPrintResult(Map<String, String> creds) {
        System.out.println("--------------------");
        System.out.println("Credentials:");
        creds.forEach((key, value) -> System.out.println(key + " -> " + value));
        boolean isCredsOk = checkUserCredentials(creds.get(LOGIN), creds.get(PASSWORD), creds.get(PASSWORD_CONFIRM));
        System.out.printf(isCredsOk ? "---%nGOOD credentials%n" : "---%nBAD credentials%n");
        System.out.println("--------------------");
    }

    private Map<String, String> getValidCredentials() {
        String pass = "goodPassword26";
        return createCredentials("validLogin", pass, pass);
    }

    private Map<String, String> createCredentials(String login, String password, String passwordConfirm) {
        return new HashMap<>(){{
            put(LOGIN, login);
            put(PASSWORD, password);
            put(PASSWORD_CONFIRM, passwordConfirm);
        }};
    }
}
