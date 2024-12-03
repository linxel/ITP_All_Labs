import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

public class ex_2 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String randomString = generateRandomString(random);
            stringList.add(randomString);
            stringList.add(randomString);
        }

        System.out.println(stringList);

        List<String> filteredList = stringList.stream()
                .filter(s -> !s.isEmpty())
                .filter(s -> !Pattern.compile(".*\\d.*").matcher(s).matches())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(filteredList);
    }

    private static String generateRandomString(Random random) {
        int length = random.nextInt(10) + 1;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int charType = random.nextInt(3);
            if (charType == 0) {
                char c = (char) (random.nextInt(26) + 'a');
                sb.append(c);
            } else if (charType == 1) {
                char c = (char) (random.nextInt(26) + 'A');
                sb.append(c);
            } else {
                char c = (char) (random.nextInt(10) + '0');
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
