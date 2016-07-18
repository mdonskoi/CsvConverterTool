import org.apache.commons.io.LineIterator;

import java.io.*;
import java.nio.charset.Charset;


public class Rd {


    public static void main(String[] args) throws IOException {

        String account = "Account";
        String transfers = "Transfers";
        String description = "Description";
        String payee = "Payee";
        String category = "Category";
        String date = "Date";
        String time = "Time";
        String memo = "Memo";
        String amount = "Amount";
        String currency = "Currency";
        String checkNumber = "Check #";


        InputStreamReader in = null;
        OutputStreamWriter out = null;

        long START = System.currentTimeMillis();

        try {
            in = new InputStreamReader(new FileInputStream(new File(Main.FILE_NAME)), Charset.defaultCharset());
            LineIterator it = new LineIterator(in);
            while (it.hasNext()) {

                System.out.println(it.nextLine());
                System.out.println("---------------------------------------------------------------------");
            }

            try (FileWriter writer = new FileWriter(Main.OUT_CSV_FILE_NAME, false)) {
                // запись всей строки
                String text1 = "TEXXXXXT";
                for (int i = 0; i < 100; i++) {
                    text1 = text1 + "rrrr";
                    String CsvText = new StringBuilder()
                            .append(account)
                            .append(",")
                            .append(transfers)
                            .append(",")
                            .append(description)
                            .append(",")
                            .append(payee)
                            .append(",")
                            .append(category)
                            .append(",")
                            .append(date)
                            .append(">")
                            .append(time)
                            .append(",")
                            .append(memo)
                            .append(",")
                            .append(amount)
                            .append(",")
                            .append(currency)
                            .append(",")
                            .append(checkNumber).toString();
                    writer.write(CsvText);
                    writer.append('\n');
                    writer.append('E');
                }// TODO: 7/5/16 correct the algorytm  
                // запись по символам


                writer.flush();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }

        } catch (IOException e) {
            // log error
        } finally {
            in.close();
        }

        try {
            in = new InputStreamReader(new FileInputStream(new File(Main.OUT_CSV_FILE_NAME)), Charset.defaultCharset());
            LineIterator it = new LineIterator(in);
            while (it.hasNext()) {

                System.out.println(it.nextLine());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            in.close();
        }

        long STOP = System.currentTimeMillis();
        System.out.print("Time spent: ");
        System.out.print(STOP - START);
        System.out.println(" mls");

    }

}
