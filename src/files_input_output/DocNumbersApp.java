package files_input_output;

import files_input_output.exceptions.FilePathException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author annasavasteeva
 * @date 03.05.2026
 */
public class DocNumbersApp {

    public void runApp() {

        Scanner sc = new Scanner(System.in);
        File file = new File(getPathToFile(sc));

        try (FileReader fileReader = new FileReader(file.getPath())) {

//        TODO: Проверять каждую строку на соответствие валидному номеру документа:
//        - если номер валиден, записать в соответствующий файл-отчет
//        - если номер невалиден, записать в другой файл-отчет и добавить информацию, почему он невалиден
//        Валидный номер:
//        - начинается с docnum или contract
//        - содержит только буквы и цифры
//        - длина == 15 символов

        } catch (IOException e) {
            e.printStackTrace();
        }


        sc.close();
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
