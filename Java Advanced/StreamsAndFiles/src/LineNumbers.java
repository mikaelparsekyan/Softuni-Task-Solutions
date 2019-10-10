import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineNumbers {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputFilePath = userDir + "/res/input.txt";
        String outputFilePath = userDir + "/res/output.txt";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputFilePath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFilePath))) {
            String inputLine = reader.readLine();
            int lineCounter = 1;
            while (inputLine != null) {
                writer.write(String.format("%d. " , lineCounter) + inputLine);
                writer.newLine();
                lineCounter++;
                inputLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
