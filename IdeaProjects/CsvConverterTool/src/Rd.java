import org.apache.commons.io.LineIterator;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by mikhail on 7/3/16.
 */
public class Rd {

    public static void main(String[] args) throws IOException {
        InputStreamReader in = null;
        OutputStreamWriter out = null;
        try {
            in = new InputStreamReader(new FileInputStream(new File(Main.FILE_NAME)), Charset.defaultCharset());
            LineIterator it = new LineIterator(in);
            while (it.hasNext()) {

                System.out.println(it.nextLine());
                System.out.println("---------------------------------------------------------------------");
            }
          out = new OutputStreamWriter(new FileOutputStream(new File(Main.OUT_FILE_NAME)));

//////////////////////////

            try(FileWriter writer = new FileWriter(Main.OUT_FILE_NAME, false))
            {

                while (it.hasNext()) {
// запись всей строки
                    String text = it.nextLine() + "ffffff";
                    writer.write(text);
                }

                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }

//////////////////////////////


            try(FileWriter writer = new FileWriter(Main.OUT_FILE_NAME, false))
            {
                // запись всей строки
               // String text = "Мама мыла раму, раму мыла мама";
                String text1 = "TEXXXXXT";
                for (int i = 0; i<100; i++) {
                    text1 = text1 + "rrrr";
                    String text = "Мама мыла раму, раму мыла мама";
                    writer.write(text1);
                    writer.append('\n');
                    writer.append('E');
                }// TODO: 7/5/16 correct the algorytm  
                // запись по символам


                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }



            //////////////////////////////////
        } catch (IOException e) {
            // log error
        } finally {
            in.close();
        }
    }

}
