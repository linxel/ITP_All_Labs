class Animal {
    protected double height;
    protected double weight;
    protected String color;

// ex from LAB 8

    public Animal(double height, double weight, String color) {
        this.height = height;
        this.weight = weight;
        this.color = color;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void eat() {
        System.out.println("The animal is eating.");
    }

    public void sleep() {
        System.out.println("The animal is sleeping.");
    }

    public void makeSound() {
        System.out.println("The animal is making a sound.");
    }

    @Deprecated
    public void oldMakeSound() {
        System.out.println("This method is deprecated. Use makeSound() instead.");
    }

    @Deprecated
    public void sleepp() {
        System.out.println("This method is deprecated. Use sleep() instead.");

    }
}


class Cow extends Animal {
    public Cow(double height, double weight, String color) {
        super(height, weight, color);
    }

    @Override
    public void makeSound() {
        System.out.println("The cow is mooing.");
    }
}

class Cat extends Animal {
    public Cat(double height, double weight, String color) {
        super(height, weight, color);
    }

    @Override
    public void makeSound() {
        System.out.println("The cat is meowing.");
    }
}

class Dog extends Animal {
    public Dog(double height, double weight, String color) {
        super(height, weight, color);
    }

    @Override
    public void makeSound() {
        System.out.println("The dog is barking.");
    }
}

public class ex_2 {
    public static void main(String[] args) {
        Animal cow = new Cow(1.5, 500, "Brown");
        Animal cat = new Cat(0.3, 5, "Black");
        Animal dog = new Dog(0.6, 20, "White");

        cow.eat();
        cow.sleep();
        cow.makeSound();
        cow.oldMakeSound();
        cow.sleepp();

        cat.eat();
        cat.sleep();
        cat.makeSound();

        dog.eat();
        dog.sleep();
        dog.makeSound();
    }
}
