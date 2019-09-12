import java.io.FileReader;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res/input.txt";

        try (FileReader fileReader = new FileReader(inputPath)) {
            int value = fileReader.read();
            while (value != -1) {
                if (value == 32 || value == 10){
                    System.out.print((char)value);
                } else {
                    System.out.print(value);
                }

                value = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
