package arrays;

import utils.ClassWithUtilsMethods;

import java.util.Arrays;

/**
 * @author annasavasteeva
 * @date 16.03.2026
 */
public class ClassworkForArrays {

    public void processClassworkForArrays() {
        System.out.println("---Classwork---");
        int randomIntsAmount = 5;
        int[] randomIntsArray = ClassWithUtilsMethods.getRandomIntArray(randomIntsAmount);
        System.out.printf("Array before squaring: %s%n", Arrays.toString(randomIntsArray));
        for (int i = 0; i < randomIntsAmount; i++) {
            int arrayEl = randomIntsArray[i];
            randomIntsArray[i] = (int) Math.pow(arrayEl, 2);
        }
        System.out.printf("Array after squaring: %s%n", Arrays.toString(randomIntsArray));
        System.out.print("Array in reverse order: ");
        for (int i = randomIntsArray.length - 1; i >= 0; i--) {
            System.out.print(randomIntsArray[i] + " ");
        }
    }
}
