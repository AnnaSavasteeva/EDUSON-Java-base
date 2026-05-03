package exceptions;

/**
 * @author annasavasteeva
 * @date 26.04.2026
 */
public class AvoidFinallyBlockApp {

    public void runApp() {
        try {
            System.out.println("Внутри try");
            System.exit(0); // Завершает JVM, finally не выполнится
        } catch (Exception e) {
            System.out.println("Внутри catch");
        } finally {
            System.out.println("Этот finally не будет вызван");
        }
    }
}
