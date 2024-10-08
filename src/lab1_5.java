public class lab1_5     {
    public static int countVowels(String input) {
        input = input.toLowerCase();
        String v = "euioa";

        int vowelCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (v.indexOf(input.charAt(i)) != -1) {
                vowelCount++;
            }
        }

        return vowelCount;
    }

    public static void main(String[] args) {
        String testString = "Hello Woaaarld!";
        int count = countVowels(testString);
        System.out.println("vowels: " + count);
    }
}

