import java.io.File;

public class lab1_12 {
    public static void main(String[] args) {
        String path = "lab1/src/lab1_12/lab1_12.java";
        System.out.println(path +
                (checkPath(path) ? " exists" : " does NOT exist"));
    }

    private static boolean checkPath(String path) {
        File file = new File(path);
        return file.exists();
    }
}

