import java.util.Scanner;

/**
 * @author annasavasteeva
 * @date 05.03.2026
 */
class HomeWork2 {

    /** Метод для запуска задач из домашнего задания к уроку 2 */
    void processHW2() {
        /*
        Задача 1:
        Напишите программу, которая будет принимать на вход число из консоли и на выход будет выводить
        сообщение четное число или нет. Для определения четности числа используйте операцию получения
        остатка от деления (операция выглядит так: '% 2').
        */
        System.out.println("---Задача 1---");
        System.out.print("Введите число: ");
        int userInt = new Scanner(System.in).nextInt();
        String evenOrOddSign = (userInt % 2 == 0) ? "четное" : "нечетное";
        System.out.printf("Вы ввели число %d — это %s число%n%n", userInt, evenOrOddSign);

        /*
        Задача 2:
        Для введенного числа t (температура на улице) вывести: Если t>–5, то вывести «Warm».
        Если –5>= t > –20, то вывести «Normal». Если –20>= t, то вывести «Cold».
        */
        System.out.println("---Задача 2---");
        System.out.print("Какая сейчас температура на улице? ");
        int t = new Scanner(System.in).nextInt();
        String weather;
        if (t > 5) weather = "Warm";
        else if (t > -20) weather = "Normal";
        else weather = "Cold";
        System.out.printf("Погода на улице: %s%n%n", weather);

        /*
        Задача 3:
        Составьте программу, выводящую на экран квадраты чисел от 10 до 20 включительно
        */
        System.out.println("---Задача 3---");
        System.out.println("Квадраты чисел от 10 до 20 включительно:");
        for (int i = 10; i <= 20; i++) {
            int square = (int) Math.pow(i, 2);
            String separator = (i < 20) ? " -> " : "\n\n";
            System.out.printf("%d%s", square, separator);
        }

        /*
        Задача 4:
        Необходимо, чтобы программа выводила на экран вот такую последовательность:
        7 14 21 28 35 42 49 56 63 70 77 84 91 98.
        В решении используйте цикл while.
        */
        System.out.println("---Задача 4---");
        System.out.print("Введите число: ");
        int userIntForIncrease = new Scanner(System.in).nextInt();
        System.out.printf("Произведение числа %d и чисел от 1 до 14:%n", userIntForIncrease);
        int counter = 1;
        while (counter <= 14) {
            int increasedNumber = userIntForIncrease * counter;
            System.out.print(increasedNumber + " ");
            counter++;
        }
        System.out.println("\n");

        /*
        Задача *:
        Напишите программу, где пользователь вводит любое целое положительное число, а программа
        суммирует все числа от 1 до введенного пользователем числа. Для ввода числа воспользуйтесь
        классом Scanner. Сделать проверку, чтобы пользователь не мог ввести некорректные данные
        */
        System.out.println("---Задача *---");
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Введите целое положительное число: ");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int userIntForSummarize = sc.nextInt();
                if (userIntForSummarize < 1) {
                    System.out.printf("Ваше число — меньше 1: %d.%n", userIntForSummarize);
                } else {
                    int sum = 0;
                    for (int i = 1; i <= userIntForSummarize; i++) {
                        sum += i;
                    }
                    System.out.printf("Сумма чисел от 1 до %d = %d", userIntForSummarize, sum);
                    break;
                }
            } else {
                System.out.printf("Значение '%s' не является целым числом.%n", sc.next());
            }
            attempts--;
        }
    }
}
