package arrays;

import utils.ClassWithUtilsMethods;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

/**
 * @author annasavasteeva
 * @date 19.03.2026
 */
public class OneDimensionalArrays {

    private int arrayLength;
    private int[] randomIntsArray;

    public OneDimensionalArrays() {
        System.out.print("Введите размер одномерного массива: ");
        this.arrayLength = new Scanner(System.in).nextInt();
        this.randomIntsArray = ClassWithUtilsMethods.getRandomIntArray(arrayLength);
    }

    public void processTasks() {
        processTaskOne();
        processTasksTwoAndThree();
        processTaskFour();
        processTaskFive();
        processTaskSix();
        processTaskWithTheStar();
    };

    private void processTaskOne() {
        System.out.printf("---Задача 1---%n" +
                "Пройти по массиву, вывести все элементы в прямом и в обратном порядке.%n");
        System.out.printf("Элементы массива: %s%n", Arrays.toString(randomIntsArray));
        System.out.print("Элементы массива в обратном порядке: [");
        for (int i = arrayLength - 1; i >= 0; i--) {
            String end = i == 0 ? "]\n" : ", ";
            System.out.print(randomIntsArray[i] + end);
        }
    }

    private void processTasksTwoAndThree() {
        System.out.printf("%n---Задача 2---%n" +
                "Найти минимальный-максимальный элементы и вывести в консоль.%n");
        var minIntOpt = stream(randomIntsArray).min();
        String minStr = minIntOpt.isPresent() ? Integer.toString(minIntOpt.getAsInt()) : "не удалось найти минимальный элемент";
        System.out.printf("Минимальный элемент массива: %s%n", minStr);
        var maxIntOpt = stream(randomIntsArray).max();
        String maxStr = maxIntOpt.isPresent() ? Integer.toString(maxIntOpt.getAsInt()) : "не удалось найти максимальный элемент";
        System.out.printf("Максимальный элемент массива: %s%n", maxStr);

        System.out.printf("%n---Задача 2 + Задача 3---%n" +
                "Найти индексы минимального и максимального элементов и вывести в консоль.%n" +
                "Полученные в Задаче 3 значения можно использовать для решения задачи 2.%n");
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 1; i < arrayLength; i++) {
            if (randomIntsArray[i] < randomIntsArray[minIdx]) {
                minIdx = i;
            }
            if (randomIntsArray[i] > randomIntsArray[maxIdx]) {
                maxIdx = i;
            }
        }
        System.out.printf("Индекс минимального элемента массива: %d. Минимальный элемент массива: %d%n", minIdx, randomIntsArray[minIdx]);
        System.out.printf("Индекс максимального элемента массива: %d. Максимальный элемент массива: %d%n", maxIdx, randomIntsArray[maxIdx]);
    }

    private void processTaskFour() {
        System.out.printf("%n---Задача 4---%n" +
                "Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести сообщение, что их нет.%n");
        int counter = 0;
        for(int arrEl : randomIntsArray) {
            if (arrEl == 0) counter++;
        }
        String infoAboutZeroElements = (counter > 0) ? Integer.toString(counter) : "в массиве нет ни одного нулевого элемента";
        System.out.printf("Количество нулевых элементов: %s%n", infoAboutZeroElements);
    }

    private void processTaskFive() {
        System.out.printf("%n---Задача 5---%n" +
                "Пройти по массиву и поменять местами элементы: первый и последний, второй и предпоследний и т.д.%n");
        for (int i = 0; i < arrayLength / 2; i++) {
            int tmp = randomIntsArray[i];
            randomIntsArray[i] = randomIntsArray[arrayLength - 1 - i];
            randomIntsArray[arrayLength - 1 - i] = tmp;
        }
        System.out.printf("Измененный массив: %s%n", Arrays.toString(randomIntsArray));
    }

    private void processTaskSix() {
        System.out.printf("%n---Задача 6---%n" +
                "Проверить, является ли массив возрастающей последовательностью (каждое следующее число больше предыдущего).%n");
        String increasingSign1 = isIntArrayIncreasing(randomIntsArray) ? "Да" : "Нет";
        System.out.printf("Массив является возрастающей последовательностью? %s%n", increasingSign1);
        if (!isIntArrayIncreasing(randomIntsArray)) {
            Arrays.sort(randomIntsArray);
            System.out.printf("Отсортированный массив: %s%n", Arrays.toString(randomIntsArray));
            String increasingSign2 = isIntArrayIncreasing(randomIntsArray) ? "Да" : "Нет";
            System.out.printf("А теперь массив — возрастающая последовательность? %s%n", increasingSign2);
        }
    }

    private void processTaskWithTheStar() {
        System.out.printf("""
                %n---Задача *---%nИмеется массив из неотрицательных чисел(любой).
                Представьте, что массив представляет целое число, например: массив {1,2,3} -> 123, {9,9,9} -> 999).
                Задача — добавить единицу к этому “числу” и на выходе получить исправленный массив.
                Массив не содержит нуля в начале, кроме самого числа 0.
                Примеры:
                Input: [1,4,0,5,6,3]
                Output: [1,4,0,5,6,4]
                Input: [9,9,9]
                Output: [1,0,0,0].%n""");
        StringBuilder sb = new StringBuilder();
        for (int arrEl : randomIntsArray) {
            sb.append(arrEl);
        }
        int numFromArray = Integer.parseInt(sb.toString());
        System.out.printf("Число из массива: %d%n", numFromArray);
        int newNumFromArray = numFromArray + 1;
        System.out.printf("Новое число из массива: %d%n", newNumFromArray);
        String newNumFromArrayStr = String.valueOf(newNumFromArray);
        int[] newIntsArrayByForLoop = new int[newNumFromArrayStr.length()];
        for (int i = 0; i < newIntsArrayByForLoop.length; i++) {
            newIntsArrayByForLoop[i] = Character.getNumericValue(newNumFromArrayStr.charAt(i));
        }
        System.out.printf("Новый массив через цикл for: %s%n", Arrays.toString(newIntsArrayByForLoop));
        int[] newIntsArrayByStream = newNumFromArrayStr
                .chars()
                .map(Character::getNumericValue)
                .toArray();
        System.out.printf("Новый массив через Stream Api: %s%n", Arrays.toString(newIntsArrayByStream));
    }

    private boolean isIntArrayIncreasing(int[] intArray) {
        boolean isArrayIncreasing = false;
        for (int i = 0; i < intArray.length - 1; i++) {
            isArrayIncreasing = intArray[i] < intArray[i + 1];
        }
        return isArrayIncreasing;
    }
}
