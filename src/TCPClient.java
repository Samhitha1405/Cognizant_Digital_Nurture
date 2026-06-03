import java.net.*;
import java.io.*;
public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket sock = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
        System.out.println("Server says: " + in.readLine());
        out.println("Hello from Client!");
        sock.close();
    }
}