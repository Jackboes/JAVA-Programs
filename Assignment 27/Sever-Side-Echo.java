import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(6000)) {
            System.out.println("Echo Server listening on port 6000...");
            try (Socket socket = server.accept()) {
                System.out.println("Client connected.");
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Received: " + msg);
                    out.println("Echo: " + msg);          // send same message back
                    if (msg.equalsIgnoreCase("exit")) break;
                }
            }
            System.out.println("Server stopped.");
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
