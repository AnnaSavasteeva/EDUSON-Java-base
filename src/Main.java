import exceptions.AuthorizationExceptionsApp;
import exceptions.AvoidFinallyBlockApp;

public class Main {

    public static void main(String[] args) {
        new AuthorizationExceptionsApp().runApp();
        new AvoidFinallyBlockApp().runApp();
    }
}