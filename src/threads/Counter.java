package threads;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class Counter {

    private int count;

    public void increase() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
