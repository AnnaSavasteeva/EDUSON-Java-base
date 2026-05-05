package files_input_output;

import files_input_output.exceptions.EmptyFileException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

    private static final String REPORTS_DIR = "resources/files";
    private static final String DOC_NUMBERS_REPORT = "valid_doc_nums.txt";
    private static final String INVALID_DOC_NUMBERS_REPORT = "invalid_doc_nums.txt";

    public void runApp() {
//        TODO: обрабатывать csv-файл
//        TODO: создавать файлы с уникальными именами (см. ИИ)

        try (Scanner sc = new Scanner(System.in)) {
            File fileToRead = new File(getPathToFile(sc));
            List<Character> docNumbersAsChars = extractCharsFromFile(fileToRead);

            if (docNumbersAsChars.isEmpty()) throw new EmptyFileException();

            File directory = new File(REPORTS_DIR);
            if (!directory.exists()) directory.mkdirs();
            File valid_numbers = createFile(directory, DOC_NUMBERS_REPORT);
            File invalid_numbers = createFile(directory, INVALID_DOC_NUMBERS_REPORT);

            String docNumbersString = docNumbersAsChars.stream().map(String::valueOf).collect(Collectors.joining());
            List<String> docNumbersList = Arrays.asList(docNumbersString.split("\n"));
            List<String> validList = new ArrayList<>();
            List<String> invalidList = new ArrayList<>();
            docNumbersList.forEach(docNumber -> {
                StringBuilder numberProblems = new StringBuilder();
                if (!isStartValid(docNumber)) numberProblems.append("- номер должен начинаться с 'docnum' или 'contract'\n");
                if (!isLengthValid(docNumber)) numberProblems.append("- номер должен состоять из 15 символов\n");
                if (!isContentValid(docNumber)) numberProblems.append("- номер должен состоять только из букв и цифр\n");

                if (!numberProblems.isEmpty()) {
                    numberProblems.insert(0, format("[%s]:\n", docNumber));
                    invalidList.add(numberProblems.toString());
                } else {
                    validList.add(format("[%s]\n", docNumber));
                }
            });
            writeStringsToFile(invalid_numbers, invalidList);
            writeStringsToFile(valid_numbers, validList);
        }
    }

    private void writeStringsToFile(File file, List<String> strings) {
        try (FileWriter fw = new FileWriter(file.getPath())) {
            for(String str : strings) {
                fw.write(str);
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace() ;
        }
    }

    private boolean isContentValid(String docNumber) {
        return docNumber.matches("^[a-zA-Z0-9]+$");
    }

    private boolean isLengthValid(String docNumber) {
        return docNumber.length() == 15;
    }

    private boolean isStartValid(String docNumber) {
        return docNumber.startsWith("docnum") || docNumber.startsWith("contract");
    }

    private File createFile(File directory, String fileName) {
        File file = new File(directory, fileName);
        try {
            if (file.createNewFile()) System.out.println("Создан файл: " + file.getAbsoluteFile());
            else System.out.println("Файл уже существует");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    private List<Character> extractCharsFromFile (File file) {
        List<Character> charsList = new ArrayList<>();
        try (FileReader fr = new FileReader(file.getPath())) {
            int i;
            while ((i = fr.read()) != -1) {
                charsList.add((char) i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
