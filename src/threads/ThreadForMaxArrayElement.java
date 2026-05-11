package threads;

import static java.util.Arrays.stream;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class ThreadForMaxArrayElement implements Runnable {

    private final int[] array;

    public ThreadForMaxArrayElement(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        var maxOpt = stream(array).max();
        var maxStr = maxOpt.isPresent() ? Integer.toString(maxOpt.getAsInt()) : "не удалось найти максимальный элемент";
        System.out.printf("Максимальный элемент массива: %s%n", maxStr);
    }
}
