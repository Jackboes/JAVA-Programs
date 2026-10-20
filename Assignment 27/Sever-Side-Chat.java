import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Chat Server started. Waiting for client on port 5000...");
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String msg;
            while (true) {
                msg = in.readLine();
                if (msg == null || msg.equalsIgnoreCase("bye")) {
                    System.out.println("Client left the chat.");
                    break;
                }
                System.out.println("Client: " + msg);
                System.out.print("Server: ");
                String reply = console.readLine();
                out.println(reply);
                if (reply.equalsIgnoreCase("bye")) break;
            }
            socket.close();
            System.out.println("Server closed.");
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
