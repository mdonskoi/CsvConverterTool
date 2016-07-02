import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    public static String FILE_NAME = "/Users/mikhail/Desktop/Лист1-Table 1.csv";

    private static int n = 0;
    private static String line;

    public static void main(String[] args) {




        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            n = (int) br.lines().count();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long STARTTIME = System.currentTimeMillis();

        try {
            Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            while (br.lines().count() != 0) {
                line = br.readLine();
                System.out.println(br.lines() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ///////////////

        try {

            String content = line;

            File file = new File("/Users/mikhail/Desktop/Лист1-Table 11111.csv");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.close();

            System.out.println(" Write Done");

        } catch (IOException e) {
            e.printStackTrace();
        }

        ////////////

        long ENDTIME = System.currentTimeMillis();


        System.out.println();
        System.out.println(n + " lines");
        System.out.print("Time spent: ");
        System.out.println(ENDTIME - STARTTIME + " mlsec");


        // TODO: 6/30/16 make CSV writer
    }
}
