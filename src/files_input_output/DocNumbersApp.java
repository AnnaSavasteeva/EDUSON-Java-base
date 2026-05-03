package files_input_output;

import files_input_output.exceptions.FilePathException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author annasavasteeva
 * @date 03.05.2026
 */
public class DocNumbersApp {

    public void runApp() {
        try (Scanner sc = new Scanner(System.in)) {
            File file = new File(getPathToFile(sc));
            List<Character> docNumbers = new ArrayList<>();
            List<String> docNumbersList = new ArrayList<>();

//            TODO: вынести в метод
            try (FileReader fr = new FileReader(file.getPath())) {
                int i;
                while ((i = fr.read()) != -1) {
                    docNumbers.add((char) i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

//            TODO: завершать приложение, если файл оказался пустым
            docNumbers.isEmpty();

            String docNumbersString = docNumbers.stream().map(String::valueOf).collect(Collectors.joining());
            docNumbersList = Arrays.asList(docNumbersString.split("\\r+"));
            docNumbersList.forEach(docNumber -> {
//        TODO: создать метод валидации номера документа:
//        - начинается с docnum или contract
//        - содержит только буквы и цифры
//        - длина == 15 символов
            });

//        TODO: если номер валиден, записать в соответствующий файл-отчет

//        TODO: если номер невалиден, записать в другой файл-отчет и добавить информацию, почему он невалиден
        }
    }

    private String getPathToFile(Scanner sc) {
        System.out.println("Укажите путь к файлу: ");
        String path = sc.nextLine();
        if (!isPathValid(path)) throw new FilePathException();
        return path;
    }

    private boolean isPathValid(String filePath) {
//        TODO: добавить проверку валидности символов в пути: буквы, косая черта, цифры?
        return filePath != null && !filePath.trim().isEmpty();
    }
}
