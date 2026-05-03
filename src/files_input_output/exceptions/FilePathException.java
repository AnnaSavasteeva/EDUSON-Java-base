package files_input_output.exceptions;

/**
 * @author annasavasteeva
 * @date 03.05.2026
 */
public class FilePathException extends RuntimeException {

    public FilePathException() {
        super("Путь к файлу содержит ошибки");
    }

    @Override
    public String toString() {
        return "WrongLoginException{" +
                "message=" + getMessage() +
                "}";
    }
}
