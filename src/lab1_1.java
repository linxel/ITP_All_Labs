import java.util.Scanner;


public class lab1_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println("a = " + a);
        System.out.println("b = " + b + "\n");
        a += b;
        b = a - b;
        a -= b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        s.close();
    }
}
