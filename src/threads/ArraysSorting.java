package threads;

import utils.ClassWithUtilsMethods;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.asList;
import static threads.ArraySortType.*;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class ArraysSorting {

    public void runApp() {
        System.out.print("Укажите размер массивов: ");
        int arrayLength = new Scanner(System.in).nextInt();

        int[] arr1 = ClassWithUtilsMethods.getRandomIntArray(arrayLength);
        int[] arr2 = ClassWithUtilsMethods.getRandomIntArray(arrayLength);
        int[] arr3 = ClassWithUtilsMethods.getRandomIntArray(arrayLength);
        System.out.printf("Массив 1: %s%n", Arrays.toString(arr1));
        System.out.printf("Массив 2: %s%n", Arrays.toString(arr2));
        System.out.printf("Массив 3: %s%n", Arrays.toString(arr3));

        Thread insertionSortThread = new Thread(new ThreadForArraySort(arr1, INSERTION));
        Thread selectionSortThread = new Thread(new ThreadForArraySort(arr2, SELECTION));
        Thread bubbleSortThread = new Thread(new ThreadForArraySort(arr3, BUBBLE));

        asList(insertionSortThread, selectionSortThread, bubbleSortThread).forEach(Thread::run);

        System.out.printf("Массив 1 после сортировки: %s%n", Arrays.toString(arr1));
        System.out.printf("Массив 2 после сортировки: %s%n", Arrays.toString(arr2));
        System.out.printf("Массив 3 после сортировки: %s%n", Arrays.toString(arr3));
    }
}
