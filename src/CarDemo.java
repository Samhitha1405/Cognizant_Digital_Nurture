public class CarDemo {
    static class Car {
        String make, model;
        int year;
        Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
        void displayInfo() {
            System.out.println("Car: " + year + " " + make + " " + model);
        }
    }
    public static void main(String[] args) {
        Car c1 = new Car ("BMW", "X5", 2020);
        Car c2 = new Car ("Lamborghini", "Aventador", 2021);
        c1.displayInfo();
        c2.displayInfo();
    }
}