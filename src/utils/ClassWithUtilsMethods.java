package utils;

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

    public static int getRandomInt() {
        return (int) (Math.random() * 101);
    }
}
