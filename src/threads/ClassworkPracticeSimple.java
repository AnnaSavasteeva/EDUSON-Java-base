package threads;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class ClassworkPracticeSimple {

    public void runApp() {
        System.out.println("Поток main начинает свою работу");

        Runnable child = new Child();
        Thread childThread = new Thread(child);
        childThread.start();
        try {
            childThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Поток main завершает свою работу");
    }
}
