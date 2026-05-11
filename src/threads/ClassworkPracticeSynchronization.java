package threads;

import static java.util.Arrays.asList;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class ClassworkPracticeSynchronization {

    public void runApp() {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new CounterThread(counter));
        Thread thread2 = new Thread(new CounterThread(counter));
        Thread thread3 = new Thread(new CounterThread(counter));
        Thread thread4 = new Thread(new CounterThread(counter));
        Thread thread5 = new Thread(new CounterThread(counter));

        asList(thread1, thread2, thread3, thread4, thread5).forEach(Thread::start);
    }
}
