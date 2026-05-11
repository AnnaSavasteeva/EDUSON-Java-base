package files_input_output;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author annasavasteeva
 * @date 26.04.2026
 */
public class RomeoAndJulietProcess {

    public void runApp() {
        File romeoJulietFile = new File("resources/files/romeo-and-juliet.txt");
        File longestWordFile = new File("resources/files/longest-word-from-romeo-and-juliet.txt");
        List<String> romeoJulietWords = new ArrayList<>();

        try (FileReader fr = new FileReader(romeoJulietFile.getPath())) {
            int i;
            List<Character> romeoJulietChars = new ArrayList<>();
            while ((i = fr.read()) != -1) {
                romeoJulietChars.add((char) i);
            }
            String romeoJulietString = romeoJulietChars.stream().map(String::valueOf).collect(Collectors.joining());
            romeoJulietWords = Arrays.asList(romeoJulietString.split("\\s+"));
        } catch (IOException e) {
            e.printStackTrace() ;
        }

        try (FileWriter fw = new FileWriter(longestWordFile.getPath())) {
            String longestWord = getLongestWord(romeoJulietWords);
            fw.write(longestWord);
            fw.flush();
            System.out.printf("The longest word in 'Romeo and Juliet is '%s'.%nThis word was written to file %s",
                    longestWord,
                    longestWordFile.getName());
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }

    private String getLongestWord(List<String> words) {
        return words.stream()
                .max(Comparator.comparing(String::length))
                .orElseThrow(RuntimeException::new);
    }
}
