import oop.abstract_classes.DoctorProcess;
import oop.reflection.AppleProcess;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String str1 = "My awesome string first";
        String str2 = "My awesome string second and it's middle";
        String str3 = "My awesome string third and it's final";

        String[] userStringsArray = {str1, str2, str3};
        Arrays.sort(userStringsArray, Comparator.comparing(String::length));

        System.out.printf("Самая короткая строка: `%s`. Ее длина — %d.%n", userStringsArray[0], userStringsArray[0].length());
        System.out.printf("Самая длинная строка: `%s`. Ее длина — %d.%n", userStringsArray[2], userStringsArray[2].length());

        System.out.println("---------");

        System.out.println("Строки в порядке возрастания значений их длины:");
        for(String str : userStringsArray) {
            System.out.println(str);
        }

        System.out.println("---------");
        double strAverageLength = Arrays.stream(userStringsArray).mapToInt(String::length).average().orElse(0.0);
        System.out.printf("Средняя длина строки: %f%n", strAverageLength);
        for(String str : userStringsArray) {
            if (str.length() < strAverageLength) {
                System.out.printf("`%s`. Длина — %d.%n", str, str.length());
            }
        }
    }
}