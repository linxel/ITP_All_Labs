import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex_5 {
    public static void main(String[] args) {
        Map<String, Integer> valueCountMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter values (type 'exit' to stop):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            valueCountMap.put(input, valueCountMap.getOrDefault(input, 0) + 1);
        }

        boolean hasRepetitiveValues = false;
        for (Map.Entry<String, Integer> entry : valueCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                hasRepetitiveValues = true;
                System.out.println("Value: " + entry.getKey() + ", Count: " + entry.getValue());
            }
        }

        if (!hasRepetitiveValues) {
            System.out.println("No repetitive values found.");
        }

        scanner.close();
    }
}
