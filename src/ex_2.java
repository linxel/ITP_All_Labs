import java.util.HashSet;
import java.util.Set;

class Animal {
    protected String nickname;

    public Animal(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void voice() {
        System.out.println(nickname + " makes a sound");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return nickname.equals(animal.nickname);
    }

    @Override
    public int hashCode() {
        return nickname.hashCode();
    }
}

class Cat extends Animal {
    private int purLoudness;

    public Cat(String nickname, int purLoudness) {
        super(nickname);
        this.purLoudness = purLoudness;
    }

    @Override
    public void voice() {
        System.out.println(nickname + " purrs with loudness " + purLoudness);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return purLoudness == cat.purLoudness;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + purLoudness;
        return result;
    }
}

class Dog extends Animal {
    private int barkingLoudness;

    public Dog(String nickname, int barkingLoudness) {
        super(nickname);
        this.barkingLoudness = barkingLoudness;
    }

    @Override
    public void voice() {
        System.out.println(nickname + " barks with loudness " + barkingLoudness);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return barkingLoudness == dog.barkingLoudness;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + barkingLoudness;
        return result;
    }
}

public class ex_2 {
    private Set<Animal> animals = new HashSet<>();
    private Set<Cat> cats = new HashSet<>();
    private Set<Dog> dogs = new HashSet<>();

    public void addAnimals(Animal animal) {
        animals.add(animal);
    }

    public void addCats(Cat cat) {
        cats.add(cat);
    }

    public void addDogs(Dog dog) {
        dogs.add(dog);
    }

    public void displayAnimals() {
        System.out.println("Animals:");
        for (Animal animal : animals) {
            System.out.println(animal.getNickname());
        }
    }

    public void makeTalk() {
        System.out.println("Animals making sounds:");
        for (Animal animal : animals) {
            animal.voice();
        }
    }

    public static void main(String[] args) {
        ex_2 main = new ex_2();
        main.addAnimals(new Animal("GenericAnimal"));
        main.addAnimals(new Cat("A", 5));
        main.addAnimals(new Dog("B", 7));
        main.addCats(new Cat("C", 3));
        main.addCats(new Cat("D", 6));
        main.addDogs(new Dog("E", 8));
        main.addDogs(new Dog("F", 4));
        main.displayAnimals();
        main.makeTalk();
    }
}
