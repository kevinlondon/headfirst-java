
/*
Makes a socket, makes a BufferedReader, and reads a single line from server app.
*/

import java.io.*;
// class Socket is in java.net
import java.net.*;


public class DailyAdviceClient {

    public void go() {
        // Many things could go wrong here.
        try {
            // Make socket connection to service on 4242, same host as localhost
            Socket s= new Socket("127.0.0.1", 4242);

            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            // Chain a BufferedReader to an InputStreamReader to the input stream from socket
            BufferedReader reader = new BufferedReader(streamReader);

            // readline() method is same as using BufferedReader to file.
            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);

            // Close out of all the streams
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
