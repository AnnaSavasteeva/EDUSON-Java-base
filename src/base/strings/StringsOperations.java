package base.strings;

import java.util.*;

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
        processTaskThree();
        System.out.println("------------------");
        processTaskFour();
        System.out.println("------------------");
        processTaskFive();
        System.out.println("------------------");
        processTaskWithStar();
        System.out.println("------------------");
//        sc.close();
    }

    private void processTaskWithStar() {
        System.out.printf("""
                -----Задача со звездочкой-----
                Дана строка произвольной длины с произвольными словами. 
                Написать программу для проверки, является ли любое выбранное слово в строке палиндромом.%n---%n""");
        String randomWord1 = getRandomWordFromStrings(userStringsArray);
        printIsWordAPalindrome(randomWord1, isPalindromeViaStringBuilder(randomWord1));
        String randomWord2 = getRandomWordFromStrings(userStringsArray);
        printIsWordAPalindrome(randomWord2, isPalindromeViaLoop(randomWord2));
    }

    private void printIsWordAPalindrome(String word, boolean isWordPalindrome) {
        String answer = isWordPalindrome ? "Да": "Нет";
        System.out.printf("Слово `%s` — палиндром? %s.%n", word, answer);
    }

//    ИИ утверждает, что этот способ наиболее эффективный по памяти и времени
    private boolean isPalindromeViaLoop(String word) {
        if (word == null) return false;
        word = word.toLowerCase();
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindromeViaStringBuilder(String word) {
        if (word == null) return false;
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reversed);
    }

    private String getRandomWordFromStrings(String[] stringsArray) {
        Random random = new Random();
        String randomStr = stringsArray[random.nextInt(stringsArray.length)];
        String[] words = randomStr.split("\\s+");
        return words[random.nextInt(words.length)];
    }

    private void processTaskFive() {
        System.out.printf("""
                -----Задача 5-----
                Вывести на консоль новую строку, в которой задублирована каждая буква из начальной строки.
                Например, "Hello" -> "HHeelllloo".%n---%n""");
        for(String str : userStringsArray) {
            StringBuilder doubledStringViaArrays = new StringBuilder();
            String[] words = str.split("\\s+");
            for (String word : words) {
                doubledStringViaArrays.append(getDoubleLettersWord(word));
                doubledStringViaArrays.append(" ");
            }
            System.out.println(doubledStringViaArrays.toString().trim());
        }
    }

    private String getDoubleLettersWord(String word) {
        char[] wordLetters = word.toCharArray();
        StringBuilder doubledLetters = new StringBuilder();
        for (char wordLetter : wordLetters) {
            doubledLetters.append(wordLetter);
            doubledLetters.append(wordLetter);
        }
        return doubledLetters.toString();
    }

    private void processTaskFour() {
        System.out.printf("""
                -----Задача 4-----
                Найти слово, состоящее только из различных символов. Если таких слов несколько, найти первое из них.%n---%n""");
        String taskResult = null;
        for(String str : userStringsArray) {
            String[] words = str.split("\\s+");
            for (String word : words) {
                if (isWordWithUniqueLetters(word)) {
                    taskResult = word;
                    break;
                }
            }
        }
        if (taskResult == null) {taskResult = "такое слово не найдено";}
        System.out.printf("Слово, состоящее из различных символов: %s%n", taskResult);
    }

    private boolean isWordWithUniqueLetters(String word) {
        Set<Character> letters = new HashSet<>();
        for (char letter : word.toCharArray()) {
            if (letters.contains(letter)) {
                return false;
            }
            letters.add(letter);
        }
        return true;
    }

    private void processTaskThree() {
        System.out.printf("""
                -----Задача 3-----
                Вывести на консоль те строки, длина которых меньше средней, а также их длину.%n---%n""");
        double strAverageLength = Arrays.stream(userStringsArray).mapToInt(String::length).average().orElse(0.0);
        System.out.printf("Средняя длина строки: %f%n", strAverageLength);
        for(String str : userStringsArray) {
            if (str.length() < strAverageLength) {
                System.out.printf("`%s`. Длина — %d.%n", str, str.length());
            }
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
}
