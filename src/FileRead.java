import java.io.*;
public class FileRead {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
            String s;
            System.out.println("Contents of output.txt:");
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}