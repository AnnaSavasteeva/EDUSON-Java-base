package threads;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class ClassworkTheory {

    public void runApp() {
        System.out.println(Thread.currentThread().getName());

        Thread viaThread = new MyThread();
        viaThread.start();
        System.out.println(viaThread.getName());

        Runnable myRunnable = new MyRunnable();
        Thread viaRunnable = new Thread(myRunnable);
        viaRunnable.start();
        System.out.println(viaRunnable.getName());
    }
}
