import java.io.*;
import java.net.*;

public class MultiClient {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 12345;

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))
        ) {
            // Server welcome message
            String welcome = serverIn.readLine();
            if (welcome != null) System.out.println(welcome);

            System.out.println("Type a message. Type 'exit' to quit.");
            String line;
            while ((line = console.readLine()) != null) {
                serverOut.println(line);               // send to server
                String reply = serverIn.readLine();    // get server reply
                if (reply == null) {
                    System.out.println("Server closed connection.");
                    break;
                }
                System.out.println("From server: " + reply);
                if (line.trim().equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}