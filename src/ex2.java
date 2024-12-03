import java.util.Scanner;

enum Drinks {
    COKE("Coke Cola", 1.50),
    SPRITE("Sprite", 1.25),
    FANTA("Fanta", 1.75);

    private final String name;
    private final double price;

    Drinks(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

enum Money {
    ONE(1.00),
    TWO(2.00),
    FIVE(5.00),
    TEN(10.00),
    TWENTY(20.00),
    FIFTY(50.00),
    HUNDRED(100.00);

    private final double denomination;

    Money(double denomination) {
        this.denomination = denomination;
    }
    public double getDenomination() {
        return denomination;
    }
}

public class ex2 {
    private double insertedMoney;

    public static void main(String[] args) {
        ex2 vm = new ex2();
        Scanner scanner = new Scanner(System.in);

        vm.showMenu();

        System.out.print("Insert money (e.g., 1, 2, 5, 10, 20, 50, 100): ");
        double insertedMoney = scanner.nextDouble();
        vm.insertMoney(insertedMoney);

        System.out.print("Choose a drink (1 for Coke Cola, 2 for Sprite, 3 for Fanta): ");
        int choice = scanner.nextInt();
        vm.buyDrink(choice);

        scanner.close();
    }

    public void showMenu() {
        System.out.println("Menu:");
        for (Drinks drink : Drinks.values()) {
            System.out.println(drink.getName() + " - $" + drink.getPrice());
        }
    }

    public void insertMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please insert a positive amount.");
            return;
        }
        insertedMoney += amount;
        System.out.println("Inserted $" + amount);
    }

    public void buyDrink(int choice) {
        if (choice < 1 || choice > Drinks.values().length) {
            System.out.println("Invalid choice. Please choose a valid drink.");
            return;
        }

        Drinks selectedDrink = Drinks.values()[choice - 1];
        if (insertedMoney < selectedDrink.getPrice()) {
            System.out.println("Not enough money. Please insert more money.");
            return;
        }

        insertedMoney -= selectedDrink.getPrice();
        System.out.println("You bought " + selectedDrink.getName() + " for $" + selectedDrink.getPrice());
        returnMoney();
    }

    public void returnMoney() {
        if (insertedMoney == 0) {
            System.out.println("No money to return.");
            return;
        }

        System.out.println("Returning $" + insertedMoney);
        double remainingMoney = insertedMoney;

        for (Money money : Money.values()) {
            while (remainingMoney >= money.getDenomination()) {
                System.out.println("Returning $" + money.getDenomination());
                remainingMoney -= money.getDenomination();
            }
        }

        if (remainingMoney > 0) {
            System.out.println("Returning the closest lesser denomination for the remaining $" + remainingMoney);
        }

        insertedMoney = 0;
    }
}
