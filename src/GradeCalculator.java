import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks: ");
        int mrks = sc.nextInt();
        String grade;
        if (mrks >= 90) {
            grade = "A";
        } else if (mrks >= 80) {
            grade = "B";
        } else if (mrks >= 70) {
            grade = "C";
        } else if (mrks >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Grade: " + grade);
        sc.close();
    }
}
