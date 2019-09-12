import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res/input.txt";
        String outputPath = userDir + "/res/output.txt";
        int count = 1;
        try (BufferedReader bf = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            String line = bf.readLine();
            while (line != null) {
                if (count % 3 == 0) {
                    bw.write(line + System.lineSeparator());
                }
                count++;
                line = bf.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
