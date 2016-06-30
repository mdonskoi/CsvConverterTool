import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {
        
        
        String FILE_NAME = "/Users/mikhail/Desktop/Лист1-Table 1.csv";

        long STARTTIME = System.currentTimeMillis();

        try {
            Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long ENDTIME = System.currentTimeMillis();
        
        System.out.println();
        System.out.print("Time spent: ");
        System.out.println(ENDTIME-STARTTIME + " mlsec");

        // TODO: 6/30/16 make CSV writer 
    }
}
