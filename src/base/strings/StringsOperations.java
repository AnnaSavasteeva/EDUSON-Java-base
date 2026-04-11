package base.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author annasavasteeva
 * @date 11.04.2026
 */
public class StringsOperations {

//    private final Scanner sc;
    private final String str1;
    private final String str2;
    private final String str3;
    private final String[] userStringsArray;

    public StringsOperations() {
//        System.out.println("Введите 3 строки:");
//        this.sc = new Scanner(System.in);
        str1 = "My awesome string first";
        str2 = "My awesome string second and it's middle";
        str3 = "My awesome string third and it's final";
        userStringsArray = new String[]{str1, str2, str3};
    }

    public void runHomework() {
        System.out.println("------------------");
        System.out.printf("Ваши строки:%n %s%n", Arrays.deepToString(userStringsArray));
        processTaskOne();
        System.out.println("------------------");
        processTaskTwo();

        System.out.println("------------------");
//        sc.close();
    }

    private void processTaskTwo() {
        System.out.printf("""
                -----Задача 2-----
                Упорядочить и вывести строки в порядке возрастания значений их длины.
                NOTE: для решения задачи 1 массив строк был отсортирован по их длине, поэтому для решения 
                данной задачи достаточно просто вывести в консоль ранее отсортированный массив.%n---%n""");
        System.out.println("Строки в порядке возрастания значений их длины:");
        for(String str : userStringsArray) {
            System.out.println(str);
        }
    }

    private void processTaskOne() {
        System.out.printf("""
                -----Задача 1-----
                Найти самую короткую и самую длинную строки.
                Вывести найденные строки и их длину.%n---%n""");
        Arrays.sort(userStringsArray, Comparator.comparing(String::length));
        System.out.printf("Самая короткая строка: `%s`. Ее длина — %d.%n", userStringsArray[0], userStringsArray[0].length());
        System.out.printf("Самая длинная строка: `%s`. Ее длина — %d.%n", userStringsArray[2], userStringsArray[2].length());
    }
}
