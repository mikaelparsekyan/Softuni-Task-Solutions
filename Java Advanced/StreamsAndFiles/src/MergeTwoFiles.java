import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputFile1Path = userDir + "/res/input1File.txt";
        String inputFile2Path = userDir + "/res/input2File.txt";
        String outputFilePath = userDir + "/res/output.txt";
        try (BufferedReader reader1 = Files.newBufferedReader(Path.of(inputFile1Path));
             BufferedReader reader2 = Files.newBufferedReader(Path.of(inputFile2Path));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFilePath))) {
            readFile(reader1, writer);
            readFile(reader2, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(BufferedReader reader1, BufferedWriter writer) throws IOException {
        String inputLine = reader1.readLine();
        while (inputLine != null) {
            writer.write(inputLine);
            writer.newLine();
            inputLine = reader1.readLine();
        }
    }
}
