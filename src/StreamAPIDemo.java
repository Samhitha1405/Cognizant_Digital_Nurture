import java.util.*;
import java.util.stream.*;
public class StreamAPIDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }
        List<Integer> evenNumbers = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers:");
        System.out.println(evenNumbers);
        sc.close();
    }
}