import java.io.FileReader;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res/input.txt";

        try (FileReader fileReader = new FileReader(inputPath)) {
            int value = fileReader.read();
            while (value != -1) {
                if (value != ',' && value != '.' && value != '!' && value != '?') {
                    System.out.print((char)value);
                }
                value = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
