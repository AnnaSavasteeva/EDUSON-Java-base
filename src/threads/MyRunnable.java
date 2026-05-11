package threads;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Выполняется поток от имплементации Runnable");
    }
}
