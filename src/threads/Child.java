package threads;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class Child implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }
}
