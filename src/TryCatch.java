import java.util.Scanner;
public class TryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a numerator: ");
        int x = sc.nextInt();
        System.out.print("Enter a denominator: ");
        int y = sc.nextInt();
        try {
            int n = x / y;
            System.out.println("Result: " + n);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }
        sc.close();
    }
}
