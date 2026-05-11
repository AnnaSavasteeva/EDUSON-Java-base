package threads;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class CounterThread implements Runnable {

    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            counter.setCount(1);
            for (int i = 0; i < 4; i++ ) {
                System.out.printf("%s: %d%n", Thread.currentThread().getName(), counter.getCount());
                counter.increase();
            }
        }
    }
}
