import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ex_4 {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();

        stringSet.add("apple");
        stringSet.add("banana");
        stringSet.add("cherry");
        stringSet.add("date");
        stringSet.add("elderberry");
        stringSet.add("fig");
        stringSet.add("grape");

        System.out.println("Original Set: " + stringSet);

        Iterator<String> iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.length() % 2 != 0) {
                iterator.remove();
            }
        }

        System.out.println("Set after removing odd length elements: " + stringSet);
    }
}
