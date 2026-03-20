import utils.ClassWithUtilsMethods;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        new OneDimensionalArrays().processTasks();

        Scanner sc = new Scanner(System.in);

        System.out.printf("""
                ---Задача 1---
                1.1 Создать двумерный массив, заполнить его случайными числами.
                1.2 Добавить к каждому значению число, которое пользователь будет вводить с консоли.
                1.3 Найти сумму всех получившихся элементов и вывести в консоль.%n""");
        System.out.print("Введите ширину массива: ");
        int arrayWidth = sc.nextInt();
        System.out.print("Введите высоту массива: ");
        int arrayHeight = sc.nextInt();
        int[][] randomIntsArray = new int[arrayWidth][arrayHeight];
        for (int i = 0; i < randomIntsArray.length; i++) {
            for (int j = 0; j < randomIntsArray[i].length; j++) {
                randomIntsArray[i][j] = ClassWithUtilsMethods.getRandomInt();
            }
        }
        System.out.printf("Исходный массив: %s%n", Arrays.deepToString(randomIntsArray));
        System.out.print("Введите число, которое нужно прибавить к каждому элементу массива: ");
        int userInt = sc.nextInt();
        for (int i = 0; i < randomIntsArray.length; i++) {
            for (int j = 0; j < randomIntsArray[i].length; j++) {
                randomIntsArray[i][j] += userInt;
            }
        }
        System.out.printf("Обновленый массив: %s%n", Arrays.deepToString(randomIntsArray));
        int arrayIntsSum = 0;
        for (int[] innerArray : randomIntsArray) {
            for (int anInt : innerArray) {
                arrayIntsSum += anInt;
            }
        }
        System.out.printf("Сумма всех элементов массива: %d%n", arrayIntsSum);


        System.out.printf("""
                %n---Задача 2---
                Создать программу для раскраски шахматной доски с помощью цикла.
                Создать двумерный массив String 8х8.
                С помощью циклов задать элементам массива значения B(Black) или W(White).
                При выводе результат работы программы должен быть следующим:
                W B W B W B W B
                B W B W B W B W
                W B W B W B W B
                B W B W B W B W
                W B W B W B W B
                B W B W B W B W
                W B W B W B W B
                B W B W B W B W%n""");
        String[][] chessboard = new String[8][8];
        String white = "W";
        String black = "B";
        for (int i = 0; i < chessboard.length; i++) {
            String evenEl = (i % 2 == 0) ? white : black;
            String oddEl = evenEl.equals(white) ? black : white;
            for (int j = 0; j < chessboard[i].length; j++) {
                chessboard[i][j] = (j % 2 == 0) ? evenEl : oddEl;
            }
        }
        System.out.println("Шахматная доска:");
        for (String[] chessField : chessboard) {
            for (int j = 0; j < chessField.length; j++) {
                String end = (j == chessField.length - 1) ? "%n" : " ";
                System.out.printf(chessField[j] + end);
            }
        }
    }
}