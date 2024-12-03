public class lab10_3 {
    public static void main(String[] args) {
        // Create instances of the classes
        Submarine submarine = new Submarine();
        Duck duck = new Duck();
        Penguin penguin = new Penguin();

        // Demonstrate Submarine functionality
        submarine.swim();
        submarine.stopSwimming();

        // Demonstrate Duck functionality
        duck.swim();
        duck.stopSwimming();
        duck.fly();
        duck.stopFlying();
        duck.live();

        // Demonstrate Penguin functionality
        penguin.swim();
        penguin.stopSwimming();
        penguin.live();

        Living[] livingObjects = {duck, penguin};

        for (Living livingObject : livingObjects) {
            livingObject.live();
        }
    }
}


interface Swimmable {
    void swim();

    void stopSwimming();
}

interface Flyable {
    void fly();

    void stopFlying();
}

interface Living {
    default void live() {
        System.out.println(this.getClass().getSimpleName() + " lives");
    }
}

class Submarine implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Submarine is swimming.");
    }

    @Override
    public void stopSwimming() {
        System.out.println("Submarine stopped swimming.");
    }
}

class Duck implements Swimmable, Flyable, Living {
    @Override
    public void swim() {
        System.out.println("Duck is swimming.");
    }

    @Override
    public void stopSwimming() {
        System.out.println("Duck stopped swimming.");
    }

    @Override
    public void fly() {
        System.out.println("Duck is flying.");
    }

    @Override
    public void stopFlying() {
        System.out.println("Duck stopped flying.");
    }
}

class Penguin implements Swimmable, Living {
    @Override
    public void swim() {
        System.out.println("Penguin is swimming.");
    }

    @Override
    public void stopSwimming() {
        System.out.println("Penguin stopped swimming.");
    }
}
