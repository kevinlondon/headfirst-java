import java.io.*;
import java.net.*;

public class DailyAdviceServer {
    // Abbreviated list.
    String[] adviceList = {"Take smaller bites", "Go for the tight jeans today."};

    public void go() {
        try {
            // Run listen port on 4242
            ServerSocket serverSock = new ServerSocket(4242);
            while (true) {
                // Accept method blocks until a request comes in on spec. port
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                // Use socket connection t make print writer and send it a message.
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
