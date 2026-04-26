package files_input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author annasavasteeva
 * @date 26.04.2026
 */
public class ByteOrientedStreamsApp {

    public void runApp() {
        String text1 = "Hello" ;
        String text2 = " world!" ;
        File dir = new File("resources/files");
        File file1 = new File(dir, "Hello.txt");

        try (FileOutputStream fos = new FileOutputStream(file1.getPath())) {
            byte[] buffer1 = text1.getBytes() ;
            fos.write(buffer1 , 0, buffer1.length);
            System.out.println( "Text 1 has been written" );
            byte[] buffer2 = text2.getBytes() ;
            fos.write(buffer2 , 0, buffer2.length);
            System.out.println( "Text 2 has been written" );
        } catch (IOException ex) {
            System.out.println(ex.getMessage()) ;
        }

        try (FileInputStream fin = new FileInputStream(file1.getPath())){
            int i;
            List<Character> chars = new ArrayList<>();
            while ((i = fin.read()) != -1) {
                chars.add((char) i);
            }
            String str = chars.stream().map(String::valueOf).collect(Collectors.joining());
            System.out.println(str);
        } catch (IOException ex) {
            System.out.println(ex.getMessage()) ;
        }
    }
}
