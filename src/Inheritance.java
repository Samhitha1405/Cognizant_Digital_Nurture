public class Inheritance {
    static class Animal {
        void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }
    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Dog barks");
        }
    }
    static class Camel extends Animal {
        @Override
        void makeSound() {
            System.out.println("Camel grunts");
        }
    }
    public static void main(String[] args) {
        Animal a = new Animal();
        Dog d = new Dog();
        Camel c = new Camel();
        a.makeSound();
        d.makeSound();
        c.makeSound();
    }
}
