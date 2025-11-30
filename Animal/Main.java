package Animal;

interface Animal {
    public void sound();
}

class Dog implements Animal{
    @Override
    public void sound() {
        System.out.println("Barking");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Mewing");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound();

        if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.sound();
        }

        // Animal x = new Animal();
        // Dog d2 = (Dog) x;
        // d2.sound();
    }
    
}
