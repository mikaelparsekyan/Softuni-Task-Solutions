import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class AllCapitals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userDir = System.getProperty("user.dir");
        String inputFilePath = userDir + "/res/input.txt";
        String outputFilePath = userDir + "/res/output.txt";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputFilePath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFilePath))) {
            String inputLine = reader.readLine();
            while (inputLine != null) {
                writer.write(inputLine.toUpperCase());
                writer.newLine();
                inputLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
