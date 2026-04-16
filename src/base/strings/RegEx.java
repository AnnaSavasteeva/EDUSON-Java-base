package base.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.List.of;

/**
 * @author annasavasteeva
 * @date 16.04.2026
 */
public class RegEx {

    private static final String REGEX_ABBREVIATION = "\\b[A-ZА-ЯЁ]{2,6}\\b";

    public void runHomework() {
        System.out.println("------------------");
        processTaskOne();
    }

    private void processTaskOne() {
        System.out.printf("""
                -----Задача 1-----
                Вывести в консоль все аббревиатуры из той строки, которую пользователь вводит с клавиатуры.
                Аббревиатурой будем считать слово от 2 до 6 символов, состоящее только из прописных букв, без чисел.%n---%n""");
        System.out.printf("""
                Регулярное выражение: %s, где:
                - \\\\b — граница слова (word boundary), чтобы выделять целые слова
                - A-Z — любая прописная латинская буква (от A до Z)
                - А-ЯЁ - поддержка кириллицы
                - {2,6} — от 2 до 6 повторений%n%n""", REGEX_ABBREVIATION);
        String text = "HELLO World LONGWORD ABC ЁЛКА ЯНЬ TEST123 XYZ JAVA CO-DE A B YES";
        System.out.printf("Строка для поиска аббревиатур: %s%n", text);
        List<String> expectedAbbList = new ArrayList<>(of("HELLO", "ABC", "ЁЛКА", "ЯНЬ", "XYZ", "JAVA", "CO", "DE", "YES"));
        System.out.println("Ожидаемый список аббревиатур:");
        System.out.println(expectedAbbList);
        List<String> actualAbbList = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX_ABBREVIATION);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            actualAbbList.add(matcher.group());
        }
        System.out.println("Фактический список аббревиатур:");
        System.out.println(actualAbbList);
    }
}
