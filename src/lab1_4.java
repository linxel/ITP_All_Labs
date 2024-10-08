public class lab1_4 {
        public static void main(String[] args) {
            String str1 = "apple";
            String str2 = "banana";
            int comparisonResult = str1.compareTo(str2);
            if (comparisonResult == 0) {
                System.out.println("The strings are lexicographically equal.");
            } else if (comparisonResult < 0) {
                System.out.println(str1 + " is lexicographically less than " + str2);
            } else {
                System.out.println(str1 + " is lexicographically greater than " + str2);
            }
        }
}
