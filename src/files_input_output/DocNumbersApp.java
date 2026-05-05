package files_input_output;

import files_input_output.exceptions.EmptyFileException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * @author annasavasteeva
 * @date 03.05.2026
 */
public class DocNumbersApp {

    public void runApp() {
        try (Scanner sc = new Scanner(System.in)) {
            File file = new File(getPathToFile(sc));
            List<Character> docNumbersAsChars = extractCharsFromFile(file);

            if (docNumbersAsChars.isEmpty()) throw new EmptyFileException();

            String docNumbersString = docNumbersAsChars.stream().map(String::valueOf).collect(Collectors.joining());
            List<String> docNumbersList = Arrays.asList(docNumbersString.split("\n"));
            docNumbersList.forEach(docNumber -> {
//        TODO: создать метод валидации номера документа:
//        - начинается с docnum или contract
//        - содержит только буквы и цифры
//        - длина == 15 символов

//        TODO: если номер валиден, записать в соответствующий файл-отчет
//        TODO: если номер невалиден, записать в другой файл-отчет и добавить информацию, почему он невалиден
            });
        }
    }

    private List<Character> extractCharsFromFile (File file) {
        List<Character> charsList = new ArrayList<>();
        try (FileReader fr = new FileReader(file.getPath())) {
            int i;
            while ((i = fr.read()) != -1) {
                charsList.add((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charsList;
    }

    private String getPathToFile(Scanner sc) throws RuntimeException {
        System.out.println("Укажите путь к файлу: ");
        String path = sc.nextLine();
        if (!isPathValid(path)) {
            throw new RuntimeException(format("Путь к файлу не может быть пустым и не должен содержать пробелы: [%s]", path));
        }
        return path;
    }

    private boolean isPathValid(String filePath) {
        return filePath != null && !filePath.contains(" ");
    }
}
