public class DecompileDemo {
    private String message;
    DecompileDemo(String message) { this.message = message; }
    void display() { System.out.println("Message: " + message); }
    public static void main(String[] args) {
        new DecompileDemo("Hello Decompiler!").display();
    }
}