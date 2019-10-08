import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        String path = userDir + "/res/input.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(getSum(line.toCharArray()));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getSum(char[] value) {
        int sum = 0;
        for (int i = 0; i < value.length; i++) {
            sum += value[i];
        }
        return sum;
    }
}
