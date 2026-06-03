import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student ID : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            students.put(id, name);
        }
        System.out.print("\nEnter Student ID to search: ");
        int sid = sc.nextInt();
        String studentName = students.get(sid);
        if (studentName != null) {
            System.out.println("Student Name: " + studentName);
        } else {
            System.out.println("Student ID not found.");
        }
        sc.close();
    }
}
