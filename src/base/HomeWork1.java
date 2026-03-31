package base;

/**
 * @author annasavasteeva
 * @date 05.03.2026
 */
public class HomeWork1 {

    /** Метод для запуска задач из домашнего задания к уроку 1 */
    public void processHW1() {
        /*
        Задача 1:
        Написать приложение, которое будет вычислять и выводить значение по формуле:
        a=4*(b+c-1)/2; b и c задаем в коде самостоятельно.
        */
        int b = 3;
        int c = 4;
        int a = 4 * (b + c - 1) / 2;
        System.out.printf("---Задача 1---\n4 * (%d + %d - 1) / 2 = %d%n", b, c, a);

        /*
        Задача 2:
        В переменной n хранится двузначное число. Создайте программу, вычисляющую и выводящую
        на экран сумму цифр n. Например: n = 26, в результате мы должны получить 8 (2+6)
        */
        int initialTwoDigitNumber = 26;
        int twoDigitNumber = initialTwoDigitNumber;
        int sumOfTwoNumbers = 0;
        while (twoDigitNumber > 0) {
            sumOfTwoNumbers += twoDigitNumber % 10;
            twoDigitNumber /= 10;
        }
        System.out.printf("---Задача 2---\nСумма цифр в числе %d: %d%n", initialTwoDigitNumber, sumOfTwoNumbers);

        /*
        Задача 3:
        В переменной n хранится трёхзначное число. Создайте программу, вычисляющую и выводящую
        на экран сумму цифр n. Например: n = 126, в результате мы должны получить 9 (1+2+6).
        */
        int initialThreeDigitNumber = 126;
        int threeDigitNumber = initialThreeDigitNumber;
        int sumOfThreeNumbers = 0;
        while (threeDigitNumber > 0) {
            sumOfThreeNumbers += threeDigitNumber % 10;
            threeDigitNumber /= 10;
        }
        System.out.printf("---Задача 3---\nСумма цифр в числе %d: %d%n", initialThreeDigitNumber, sumOfThreeNumbers);

        /*
        Задача 4:
        В переменной n хранится вещественное число с ненулевой дробной частью.
        Создайте программу, округляющую число n до ближайшего целого и выводящую результат на экран
        */
        double fractional = 3.7;
        int doubleToInt = (int) (fractional + 0.5);
        System.out.printf("---Задача 4---\nЧисло %f округляется до %d%n", fractional, doubleToInt);

        /*
        Задача 5:
        В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую
        на экран результат деления q на w с остатком. Пример вывода программы (для случая,
        когда в q хранится 21, а в w хранится 8): 21 / 8 = 2 и 5 в остатке.
        */
        int q = 21;
        int w = 8;
        int divide = q / w;
        int remainder = q - (divide * w);
        System.out.printf("---Задача 5---\nРезультат деления с остатком: %d / %d = %d и %d в остатке%n", q, w, divide, remainder);

        /*
        Задача *:
        Написать программу которая будет менять местами значение целочисленных переменных.
        Пример: int a = 1; int b = 2;
        Усовершенствовать программу, использовать только 2 входные переменные (a,b)
        */
        int x = 1;
        int y = 2;
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("---Задача *---");
        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }
}
