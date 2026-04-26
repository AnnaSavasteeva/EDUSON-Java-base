package files_input_output;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author annasavasteeva
 * @date 26.04.2026
 */
public class CharacterOrientedStreamsApi {

    public void runApp() {
        String text1 = "Hello" ;
        String text2 = " world!" ;
        File dir = new File("resources/files");
        File file1 = new File(dir, "Hello.txt");

        try (FileWriter fw = new FileWriter(file1.getPath())) {
            fw.write(text1);
            fw.write(text2);
            fw.flush() ;
        } catch (Exception e) {
            e.printStackTrace() ;
        }

        try (FileReader fr = new FileReader(file1.getPath())) {
            int i;
            List<Character> chars = new ArrayList<>();
            while ((i = fr.read()) != -1) {
                chars.add((char) i);
            }
            String str = chars.stream().map(String::valueOf).collect(Collectors.joining());
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }
}
