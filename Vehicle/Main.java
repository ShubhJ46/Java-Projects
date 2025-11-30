package Vehicle;

class Vehicle {
    String brand;
    int speed;

    public Vehicle (String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void drive() {
        System.out.println("Vehicle is moving");
    }
}

class Car extends Vehicle {

    public Car(String brand, int speed) {
        super(brand, speed);
    }

    @Override
    public void drive() {
        System.out.println("Car is driving at " + speed);
    }
}

class SuperCar extends Car {
    public SuperCar (String brand, int speed) {
        super(brand, speed);
    }
 
    @Override
    public void drive() {
        System.out.println("Supercar flying at speed: " + this.speed);
    }
}



public class Main {
    public static void main(String[] args) {
        Vehicle v = new Car("Honda", 60);
        v.drive();
        
        Vehicle v2 = new SuperCar("BMW", 120);
        v2.drive();


    }
}
