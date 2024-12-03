import java.util.Scanner;

public class lab2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("calculate: ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        double number1 = Double.parseDouble(parts[0]);
        char operation = parts[1].charAt(0);
        double number2 = Double.parseDouble(parts[2]);
        double result = calculate(number1, operation, number2);
        System.out.println(result);
        scanner.close();
    }

    public static double calculate(double number1, char operation, double number2) {
        switch (operation) {
            case '+':
                return add(number1, number2);
            case '-':
                return subtract(number1, number2);
            case '*':
                return multiply(number1, number2);
            case '/':
                return divide(number1, number2);
            default:
                System.out.println("Invalid");
                return -1;
        }
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return -1;
        }
        return a / b;
    }
}
