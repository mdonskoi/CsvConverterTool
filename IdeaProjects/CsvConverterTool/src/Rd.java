import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by mikhail on 7/3/16.
 */
public class Rd {

    public static void main(String[] args) throws IOException {
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(new FileInputStream(new File(Main.FILE_NAME)), Charset.defaultCharset());
            LineIterator it = new LineIterator(in);
            while (it.hasNext()) {
                System.out.println(it.nextLine());
                System.out.println("---------------------------------------------------------------------");
            }
        } catch (IOException e) {
            // log error
        } finally {
            in.close();
        }
    }

}
