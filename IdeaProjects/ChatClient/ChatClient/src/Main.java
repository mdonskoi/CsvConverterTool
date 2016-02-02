
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class GetThread extends Thread {
    private int n;

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                URL url = new URL("http://localhost:8888/get?from=" + n);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();

                InputStream is = http.getInputStream();
                try {
                    int sz = is.available();
                    if (sz > 0) {
                        byte[] buf = new byte[is.available()];
                        is.read(buf);

                        Gson gson = new GsonBuilder().create();
                        Message[] list = gson.fromJson(new String(buf), Message[].class);

                        for (Message m : list) {
                            System.out.println(m);
                            n++;
                        }
                    }
                } finally {
                    is.close();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter login: ");
            String login = scanner.nextLine();

            GetThread th = new GetThread();
            th.setDaemon(true);
            th.start();

            while (true) {
                String text = scanner.nextLine();
                if (text.isEmpty())
                    break;

                Message m = new Message();
                m.setText(text);
                m.setFrom(login);

                try {
                    int res = m.send("http://localhost:8888/add");
                    if (res != 200) {
                        System.out.println("HTTP error: " + res);
                        return;
                    }
                } catch (IOException ex) {
                    System.out.println("Error: " + ex.getMessage());
                    return;
                }
            }
        } finally {
            scanner.close();
        }
    }
}

