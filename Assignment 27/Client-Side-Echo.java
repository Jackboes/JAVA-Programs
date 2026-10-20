import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6000)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected. Type a message ('exit' to quit).");
            String msg;
            while (true) {
                System.out.print("You: ");
                msg = console.readLine();
                if (msg == null) break;
                out.println(msg);
                System.out.println(in.readLine());        // server's echo
                if (msg.equalsIgnoreCase("exit")) break;
            }
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
