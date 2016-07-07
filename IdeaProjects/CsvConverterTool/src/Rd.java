import org.apache.commons.io.LineIterator;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.charset.Charset;


public class Rd {


    public static void main(String[] args) throws IOException {

        Data data = null;
        String typeOfTransaction = "typeOfTransaction";
        String account = "account";
        String category = "category";
        String subcategory = "subcategory";
        String currency = null;
        String descriptoin = null;
        String time = null;
        int total = 0;

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


//////////////////////////////


            try (FileWriter writer = new FileWriter(Main.OUT_CSV_FILE_NAME, false)) {
                // запись всей строки
                String text1 = "TEXXXXXT";
                for (int i = 0; i < 100; i++) {
                    text1 = text1 + "rrrr";
                    String text = "Мама мыла раму, раму мыла мама";
                    String CsvText = new StringBuilder()
                            .append(account)
                            .append(",")
                            .append(total)
                            .append(",")
                            .append(account)
                            .append(",")
                            .append("transfer")
                            .append(",")
                            .append(descriptoin)
                            .append(",")
                            .append(category)
                            .append(">")
                            .append(subcategory)
                            .append(",")
                            .append(/*data*/ System.currentTimeMillis())
                            .append(",")
                            .append(time)
                            .append(",")
                            .append(total)
                            .append(",")
                            .append(currency).toString();
                    writer.write(CsvText);
                    writer.append('\n');
                    writer.append('E');
                }// TODO: 7/5/16 correct the algorytm  
                // запись по символам


                writer.flush();
            } catch (IOException ex) {

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
