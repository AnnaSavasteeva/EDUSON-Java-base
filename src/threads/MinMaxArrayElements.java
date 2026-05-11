package threads;

import utils.ClassWithUtilsMethods;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author annasavasteeva
 * @date 11.05.2026
 */
public class MinMaxArrayElements {

    public void runApp() {
        System.out.print("Укажите размер массива: ");
        int arrayLength = new Scanner(System.in).nextInt();
        int[] randomIntsArray = ClassWithUtilsMethods.getRandomIntArray(arrayLength);
        System.out.printf("Элементы массива: %s%n", Arrays.toString(randomIntsArray));

        Thread threadForMax = new Thread(new ThreadForMaxArrayElement(randomIntsArray));
        Thread threadForMin = new Thread(new ThreadForMinArrayElement(randomIntsArray));

        threadForMax.start();
        threadForMin.start();
    }
}
