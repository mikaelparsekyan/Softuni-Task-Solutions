import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SumBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userDir = System.getProperty("user.dir");
        long totalBytes = 0L;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File(userDir + "/res/input.txt")));) {
            String line = reader.readLine();
            while (line != null) {
                totalBytes += getSum(line.toCharArray());
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(totalBytes);
    }
    private static int getSum(char[] value) {
        int sum = 0;
        for (int i = 0; i < value.length; i++) {
            sum += value[i];
        }
        return sum;
    }
}
