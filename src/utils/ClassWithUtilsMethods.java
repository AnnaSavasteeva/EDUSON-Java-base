package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author annasavasteeva
 * @date 18.03.2026
 */
public class ClassWithUtilsMethods {

    public static int[] getRandomIntArray(int arrayLength) {
        int[] randomIntsArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomIntsArray[i] = getRandomInt();
        }
        return randomIntsArray;
    }

    public static List<Integer> getRandomIntList(int listSize) {
        List<Integer> intsList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            intsList.add(getRandomInt());
        }
        return intsList;
    }

    public static int getRandomInt() {
        return (int) (Math.random() * 101);
    }

    public static void sortIntArrayByInsertion(int[] array) {
        for (int i = 1; i < array.length; i++) {
//            Начинаем со второго элемента, считая первый элемент уже отсортированным
            int key = array[i];
            int j = i - 1;

            // Сдвигаем элементы, которые больше key, на одну позицию вправо
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void sortIntArrayBySelection(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void sortIntArrayByBubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                // Сравнение соседних элементов
                if (array[j] > array[j + 1]) {
                    // Обмен элементами
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
