package Engine;

class Engine {
    public void start() {
        System.out.println("Starting engine");
    }
}

class Car {
    Engine eng;

    public Car() {
        eng = new Engine();
    }
    public void startCar() {
        System.out.println("Starting the car");
        this.eng.start();
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.startCar();
    }
}
