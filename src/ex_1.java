import java.util.Scanner;

enum Drinks {
    COKE_COLA("Coke Cola", 1.5),
    SPRITE("Sprite", 1.2),
    FANTA("Fanta", 1.0);

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
    ONE(1.0),
    TWO(2.0),
    FIVE(5.0),
    TEN(10.0),
    TWENTY(20.0);

    private final double denomination;

    Money(double denomination) {
        this.denomination = denomination;
    }

    public double getDenomination() {
        return denomination;
    }
}

public class ex_1  {
    private double insertedMoney;

    public void showMenu() {
        System.out.println("Menu:");
        for (Drinks drink : Drinks.values()) {
            System.out.println(drink.getName() + " - $" + drink.getPrice());
        }
    }       

    public void insertMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please insert a positive value.");
            return;
        }
        insertedMoney += amount;
        System.out.println("Inserted: $" + amount);
    }

    public void buyDrink(Drinks drink) {
        if (insertedMoney < drink.getPrice()) {
            System.out.println("Not enough money. Please insert more.");
            return;
        }
        insertedMoney -= drink.getPrice();
        System.out.println("You bought a " + drink.getName() + " for $" + drink.getPrice());
        returnMoney();
    }

    public void returnMoney() {
        if (insertedMoney == 0) {
            System.out.println("No money to return.");
            return;
        }
        System.out.println("Returning $" + insertedMoney);
        insertedMoney = 0;
    }


    public static void main(String[] args) {
        ex_1 vm = new ex_1();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            vm.showMenu();
            System.out.println("Insert money (1, 2, 5, 10, 20) or type 'exit' to quit:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                double amount = Double.parseDouble(input);
                boolean validAmount = false;
                for (Money money : Money.values()) {
                    if (money.getDenomination() == amount) {
                        validAmount = true;
                        break;
                    }
                }
                if (validAmount) {
                    vm.insertMoney(amount);
                } else {
                    System.out.println("Invalid denomination. Please insert 1, 2, 5, 10, or 20.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please insert a valid amount.");
            }

            System.out.println("Choose a drink (Coke Cola, Sprite, Fanta) or type 'return' to get your money back:");
            String drinkChoice = scanner.nextLine();
            if (drinkChoice.equalsIgnoreCase("return")) {
                vm.returnMoney();
            } else {
                Drinks chosenDrink = null;
                for (Drinks drink : Drinks.values()) {
                    if (drink.getName().equalsIgnoreCase(drinkChoice)) {
                        chosenDrink = drink;
                        break;
                    }
                }
                if (chosenDrink != null) {
                    vm.buyDrink(chosenDrink);
                } else {
                    System.out.println("Invalid drink choice. Please choose a valid drink.");
                }
            }
        }
        scanner.close();
    }
}
