import java.io.*;
import java.net.*;

public class MultiServer {
    public static void main(String[] args) {
        final int PORT = 12345;
        System.out.println("Server running on port " + PORT + " ...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Each client handled in its own thread
                ClientHandler handler = new ClientHandler(clientSocket);
                handler.start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
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
            out.println("Welcome! You are connected to the server. Type 'exit' to quit.");
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("From " + socket.getRemoteSocketAddress() + ": " + line);
                if (line.trim().equalsIgnoreCase("exit")) {
                    out.println("Goodbye!");
                    break;
                }
                // Echo message back
                out.println("Server echo: " + line);
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {}
            System.out.println("Client disconnected: " + socket.getRemoteSocketAddress());
        }
    }
}
