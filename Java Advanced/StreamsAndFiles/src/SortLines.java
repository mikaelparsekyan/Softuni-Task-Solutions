import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res/input.txt";
        String outputPath = userDir + "/res/output.txt";
        List<String> lines = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(inputPath))) {
            String line = bf.readLine();
            while (line != null) {
                if (!line.equals("")) {
                    lines.add(line);
                }
                line = bf.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(lines);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(outputPath));) {
            for (String line : lines) {
                bf.write(line + System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
