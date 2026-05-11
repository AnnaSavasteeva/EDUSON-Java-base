package threads;

import static java.util.Arrays.stream;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class ThreadForMinArrayElement implements Runnable {

    private final int[] array;

    public ThreadForMinArrayElement(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        var minOpt = stream(array).min();
        var minStr = minOpt.isPresent() ? Integer.toString(minOpt.getAsInt()) : "не удалось найти минимальный элемент";
        System.out.printf("Минимальный элемент массива: %s%n", minStr);
    }
}
