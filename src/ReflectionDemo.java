import java.lang.reflect.*;
public class ReflectionDemo {
    static class Greeter {
        public void hello(String name) {
            System.out.println("Hello, " + name + "!");
        }
        public int add(int a, int b) {
            return a + b;
        }
    }
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ReflectionDemo$Greeter");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        System.out.println("Methods in Greeter:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(" - " + m.getName() + " (" + m.getParameterCount() + " params)");
        }
        Method hello = clazz.getMethod("hello", String.class);
        hello.invoke(obj, "Reflection");
    }
}