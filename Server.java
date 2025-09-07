import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 12345;
        System.out.println("Server starting on port " + PORT + " ...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for a client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Create and start a handler thread for this client
                ClientHandler handler = new ClientHandler(clientSocket);
                handler.start();

                // Wait until this handler finishes (ensures only one client at a time)
                try {
                    handler.join();
                } catch (InterruptedException ie) {
                    System.out.println("Main thread interrupted while waiting for client handler.");
                }

                System.out.println("Client session ended. Ready for next client.\n");
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            out.println("Welcome! Type messages. Send 'exit' to quit.");
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received from client: " + line);
                if (line.trim().equalsIgnoreCase("exit")) {
                    out.println("Goodbye!");
                    break;
                }
                // Echo back (you can change behavior here)
                out.println("Server echo: " + line);
            }
        } catch (IOException e) {
            System.err.println("Client handler exception: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {}
        }
    }
}