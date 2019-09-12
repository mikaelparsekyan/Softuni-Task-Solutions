import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res/input.txt";

        try (FileReader fileReader = new FileReader(inputPath)) {
            int value = fileReader.read();
            while (value != -1) {
                System.out.print(Integer.toBinaryString(value) + "  ");
                value = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
