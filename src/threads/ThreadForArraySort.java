package threads;

import utils.ClassWithUtilsMethods;

import static threads.ArraySortType.*;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class ThreadForArraySort implements Runnable {

    private final int[] array;
    private final ArraySortType sortType;

    public ThreadForArraySort(int[] array, ArraySortType sortType) {
        this.array = array;
        this.sortType = sortType;
    }

    @Override
    public void run() {
        if (this.sortType.equals(INSERTION)) ClassWithUtilsMethods.sortIntArrayByInsertion(array);
        if (this.sortType.equals(SELECTION)) ClassWithUtilsMethods.sortIntArrayBySelection(array);
        if (this.sortType.equals(BUBBLE)) ClassWithUtilsMethods.sortIntArrayByBubble(array);
    }
}
