package base.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.List.of;

/**
 * @author annasavasteeva
 * @date 16.04.2026
 */
public class RegEx {

    private static final String REGEX_ABBREVIATION = "\\b[A-ZА-ЯЁ]{2,6}\\b";
    private static final String REGEX_EMAIL = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
    private static final String REGEX_DOC_NUM = "\\b\\d{4}-\\d{4}-\\d{2}\\b";
    private static final String REGEX_PHONE = "\\+\\(\\d{2}\\)\\d{7}";

    public void runHomework() {
        System.out.println("------------------");
        processTaskOne();
        System.out.println("------------------");
        processTaskWithStar();
        System.out.println("------------------");
    }

    private void processTaskWithStar() {
        System.out.printf("""
                -----Задача *-----
                Программа на вход получает произвольный текст. В этом тексте может быть номер документа(один или несколько),
                email и номер телефона.
                Номер документа в формате: xxxx-xxxx-xx, где x - это любая цифра;
                номер телефона в формате: +(xx)xxxxxxx.
                Документ может содержать не всю информацию, т.е., например, может не содержать номер телефона, или другое.
                Необходимо найти эту информацию и вывести в консоль в формате:
                email: teachmeskills@gmail.com
                document number: 1423-1512-51
                и т.д.%n---%n""");
        String inputText = "Привет! Мой email: teachmeskills@gmail.com. " +
                "А вот номер документа: 1234-5678-91. " +
                "И ещё один документ: 9876-5432-10. " +
                "И еще третий документ с неверным номером: 000-9999-11" +
                "Мой телефон: +(12)3456789. " +
                "Также email: user@example.com. " +
                "Телефон друга: +(98)7654321.";
        Map<String, List<String>> clientInfo = getClientInfo(inputText);
        for (Map.Entry<String, List<String>> entry : clientInfo.entrySet()) {
            String fieldName = entry.getKey();
            List<String> fieldValues = entry.getValue();
            if (fieldValues.isEmpty()) {
                System.out.printf("%s: данные не найдены%n", fieldName);
            } else {
                String finalFieldValue = String.join(", ", fieldValues);
                System.out.printf("%s: %s%n", fieldName, finalFieldValue);
            }
        }
    }

    private Map<String, List<String>> getClientInfo(String inputText) {
        Map<String, List<String>> clientInfo = new HashMap<>();
        clientInfo.put("email", findTextByRegEx(inputText, REGEX_EMAIL));
        clientInfo.put("document number", findTextByRegEx(inputText, REGEX_DOC_NUM));
        clientInfo.put("phone number", findTextByRegEx(inputText, REGEX_PHONE));
        return clientInfo;
    }

    private List<String> findTextByRegEx(String inputText, String regEx) {
        List<String> dataList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(inputText);
        while (matcher.find()) {
            dataList.add(matcher.group());
        }
        return dataList;
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
