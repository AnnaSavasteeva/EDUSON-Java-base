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
}
