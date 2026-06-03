import java.util.Scanner;
public class TypeCasting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double d = 9.78;
        int i = (int) d;
        System.out.println("Double value: " + d);
        System.out.println("Integer value after casting: " + i);
        int n = sc.nextInt();
        double result = (double) n / 2;
        System.out.println("Result: " + result);
    }
}
