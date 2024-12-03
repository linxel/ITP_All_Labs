import java.io.*;

public class ex_3    {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("ok");

        } catch (FileNotFoundException e) {
            System.out.println("error " + e.getMessage());
        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
        }
    }
}
