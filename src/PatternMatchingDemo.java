public class PatternMatchingDemo {
    static void describe(Object obj) {
        String result = switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s  -> "String: \"" + s + "\"";
            case Double d  -> "Double: " + d;
            default        -> "Unknown type: " + obj.getClass().getSimpleName();
        };
        System.out.println(result);
    }
    public static void main(String[] args) {
        describe(42);
        describe("Hello");
        describe(3.14);
        describe(true);
    }
}