import java.io.*;
import java.util.Scanner;
public class FileWrite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to save: ");
        String txt = sc.nextLine();
        try (PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {
            pw.println(txt);
            System.out.println("Successfully written to output.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}