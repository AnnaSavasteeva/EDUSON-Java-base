import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class Main {

    public static void main(String[] args) {

//        new HomeWork1().processHW1();
//        new HomeWork2().processHW2();
//        new ClassworkForArrays().processClassworkForArrays();

        System.out.print("Введите размер одномерного массива: ");
        int userInt = new Scanner(System.in).nextInt();
        int[] randomIntsArray = UtilClass.getRandomIntArray(userInt);

        System.out.printf("---Задача 1---%nПройти по массиву, вывести все элементы в прямом и в обратном порядке.%n");
        System.out.printf("Элементы массива: %s%n", Arrays.toString(randomIntsArray));
        System.out.print("Элементы массива в обратном порядке: [");
        for (int i = randomIntsArray.length - 1; i >= 0; i--) {
            String end = i == 0 ? "]\n" : ", ";
            System.out.print(randomIntsArray[i] + end);
        }

        System.out.printf("%n---Задача 2, способ 1---%nНайти минимальный-максимальный элементы и вывести в консоль.%n");
        var minIntOpt = stream(randomIntsArray).min();
        String minStr = minIntOpt.isPresent() ? Integer.toString(minIntOpt.getAsInt()) : "не удалось найти минимальный элемент";
        System.out.printf("Минимальный элемент массива: %s%n", minStr);
        var maxIntOpt = stream(randomIntsArray).max();
        String maxStr = maxIntOpt.isPresent() ? Integer.toString(maxIntOpt.getAsInt()) : "не удалось найти максимальный элемент";
        System.out.printf("Максимальный элемент массива: %s%n", maxStr);

        System.out.printf("%n---Задача 2 + Задача 3---%nНайти индексы минимального и максимального элементов и вывести в консоль.%n" +
                "Полученные в Задаче 3 значения можно использовать для решения задачи 2.%n");
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 1; i < randomIntsArray.length; i++) {
            if (randomIntsArray[i] < randomIntsArray[minIdx]) {
                minIdx = i;
            }
            if (randomIntsArray[i] > randomIntsArray[maxIdx]) {
                maxIdx = i;
            }
        }
        System.out.printf("Индекс минимального элемента массива: %d. Минимальный элемент массива: %d%n", minIdx, randomIntsArray[minIdx]);
        System.out.printf("Индекс максимального элемента массива: %d. Максимальный элемент массива: %d%n", maxIdx, randomIntsArray[maxIdx]);

        System.out.printf("%n---Задача 4---%nНайти и вывести количество нулевых элементов. " +
                "Если нулевых элементов нет - вывести сообщение, что их нет.%n");
        int counter = 0;
        for(int arrEl : randomIntsArray) {
            if (arrEl == 0) counter++;
        }
        String infoAboutZeroElements = (counter > 0) ? Integer.toString(counter) : "в массиве нет ни одного нулевого элемента";
        System.out.printf("Количество нулевых элементов: %s%n", infoAboutZeroElements);

        System.out.printf("%3s", "a");
    }
}