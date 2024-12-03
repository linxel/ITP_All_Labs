import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Animal {
    String name;
    String type;

    Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + type;
    }
}

public class ex_3 {
    private List<Animal> animals;

    public ex_3() {
        animals = new ArrayList<>();
    }

    public void addAnimal(String name, String type) {
        animals.add(new Animal(name, type));
    }

    public void removeAnimal(String name) {
        animals.removeIf(animal -> animal.name.equalsIgnoreCase(name));
    }

    public void updateAnimal(String name, String newName, String newType) {
        for (Animal animal : animals) {
            if (animal.name.equalsIgnoreCase(name)) {
                animal.name = newName;
                animal.type = newType;
                break;
            }
        }
    }

    public void displayAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        ex_3 animalList = new ex_3();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Animal");
            System.out.println("2. Remove Animal");
            System.out.println("3. Update Animal");
            System.out.println("4. Display Animals");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter type: ");
                    String type = scanner.nextLine();
                    animalList.addAnimal(name, type);
                    break;
                case 2:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();
                    animalList.removeAnimal(removeName);
                    break;
                case 3:
                    System.out.print("Enter name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new type: ");
                    String newType = scanner.nextLine();
                    animalList.updateAnimal(updateName, newName, newType);
                    break;
                case 4:
                    animalList.displayAnimals();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
