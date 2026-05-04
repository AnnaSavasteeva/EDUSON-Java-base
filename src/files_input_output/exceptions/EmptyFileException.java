package files_input_output.exceptions;

/**
 * @author annasavasteeva
 * @date 04.05.2026
 */
public class EmptyFileException extends RuntimeException {

    public EmptyFileException() {
        super("Не удалось извлечь данные из файла: возможно, файл пустой");
    }

    @Override
    public String toString() {
        return "EmptyFileException{" +
                "message=" + getMessage() +
                "}";
    }
}
