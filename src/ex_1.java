import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ex_1 {
    public static void main(String[] args) {
        List<Integer> n = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10) - 10;
            n.add(randomNumber);
        }
        System.out.println(n);
        List<Integer> n3 = n.stream()
                .filter(x -> x % 3 == 0)
                .map(k -> k < 0 ? -k : k)
                .toList();
        System.out.println(n3);
    }
}
