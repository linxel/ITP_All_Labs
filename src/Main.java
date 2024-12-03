abstract class lab10_1 {
    String name = null;
    boolean isAlive = false;

    abstract void born();
    
    abstract void die();

    void shoutName() {
        if (name != null) {
            System.out.println(name);
        } else {
            System.out.println("Error: Name is not set.");
        }
    }
}

class Human extends lab10_1 {
    @Override
    void born() {
        name = "HumanName"; // You can set a specific name or use a parameter
        isAlive = true;
        System.out.println("The Human " + name + " was born");
    }

    @Override
    void die() {
        isAlive = false;
        System.out.println("The Human " + name + " has died");
    }
}

class Dog extends lab10_1 {
    @Override
    void born() {
        name = "DogName"; // You can set a specific name or use a parameter
        isAlive = true;
        System.out.println("The Dog " + name + " was born");
    }

    @Override
    void die() {
        isAlive = false;
        System.out.println("The Dog " + name + " has died");
    }

    void bark() {
        if (isAlive) {
            System.out.println(name + " says: Woof");
        } else {
            System.out.println("The dog is not alive to bark.");
        }
    }
}

class Alien extends lab10_1 {
    @Override
    void born() {
        name = "AlienName"; // You can set a specific name or use a parameter
        isAlive = true;
        System.out.println("The Alien " + name + " was born");
    }

    @Override
    void die() {
        isAlive = false;
        System.out.println("The Alien " + name + " has died");
    }
}

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.born();
        human.shoutName();
        human.die();

        Dog dog = new Dog();
        dog.born();
        dog.shoutName();
        dog.bark();
        dog.die();

        Alien alien = new Alien();
        alien.born();
        alien.shoutName();
        alien.die();
    }
}
