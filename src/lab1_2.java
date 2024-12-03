import java.util.Scanner;
public class lab1_2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input: ");
            char character = scanner.next().charAt(0);
            int value = (int) character;
            System.out.println("ASCII" + character + "' is: " + value);
            scanner.close();
    }
}
