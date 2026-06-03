import java.util.*;
import java.util.stream.*;

public class RecordDemo {
    record Person(String name, int age) {}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine(); 
            people.add(new Person(name, age));
        }
        System.out.println("\nAdults:");
        people.stream().filter(p -> p.age() >= 18).forEach(p -> System.out.println(p.name() + ", age " + p.age()));
        sc.close();
    }
}