import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int yr = sc.nextInt();
        boolean isLeap = (yr % 4 == 0 && yr % 100 != 0) || (yr % 400 == 0);
        System.out.println(yr + " is " + (isLeap ? "a Leap Year" : "not a Leap Year"));
        sc.close();
    }
}
