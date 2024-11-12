import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";  // Change this to your input file path
        String outputFilePath = "output.txt"; // Change this to your output file path

        // Reading from the input file and writing to the output file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Write a new line after each line read
            }
            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Input file does not exist: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the output file: " + e.getMessage());
        }
    }
}
