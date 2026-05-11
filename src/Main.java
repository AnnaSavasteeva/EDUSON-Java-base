import threads.MyRunnable;
import threads.MyThread;

public class Main {

    public static void main(String[] args) {

        Thread viaThread = new MyThread();
        viaThread.start();

        Runnable myRunnable = new MyRunnable();
        Thread viaRunnable = new Thread(myRunnable);
        viaRunnable.start();
    }
}