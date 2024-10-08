import java.util.Scanner;

public class lab1_8 {
    public static void main(String[] args) {
        System.out.println("int: ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.printf("decimal: %d,%n" + "hexadecimal: %h,%n" + "binary: %s", value, value, Integer.toBinaryString(value));
    }
}
