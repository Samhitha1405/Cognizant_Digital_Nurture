public class OperatorPrecedence {
    public static void main(String[] args) {
        int r1 = 10 + 5 * 2;
        int r2 = (10 + 5) * 2;
        int r3 = 10 + 6 / 2 - 1;
        System.out.println("10 + 5 * 2 = " + r1);
        System.out.println("(10 + 5) * 2 = " + r2);
        System.out.println("10 + 6 / 2 - 1 = " + r3);
    }
}