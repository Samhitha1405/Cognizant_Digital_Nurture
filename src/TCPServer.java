import java.net.*;
import java.io.*;
public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");
        Socket client = ss.accept();
        System.out.println("Client connected!");
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println("Hello from Server!");
        System.out.println("Client says: " + in.readLine());
        ss.close();
    }
}