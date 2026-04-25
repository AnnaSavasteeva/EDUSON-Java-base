import exceptions.Authorization;

public class Main {

    public static void main(String[] args) {

        String log = "login678911234567892";
        String pass = "password1";
        String conformPass = "password2";
        System.out.println(Authorization.checkUserCredentials(log, pass, conformPass));
    }
}