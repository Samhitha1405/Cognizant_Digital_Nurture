import java.util.*;
public class LambdaDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names.add(sc.nextLine());
        }
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("\nSorted List:");
        names.forEach(name -> System.out.println(name));
        sc.close();
    }
}