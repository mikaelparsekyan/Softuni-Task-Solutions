import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CountCharacterTypes {
    public static void main(String[] args) {
        int[] result = new int[3];
        String userDir = System.getProperty("user.dir");
        String inputFilePath = userDir + "/res/input.txt";
        String outputFilePath = userDir + "/res/output.txt";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputFilePath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFilePath))) {
            String line = reader.readLine();
            while (line != null) {
                countSymbols(line, result);
                line = reader.readLine();
            }
            writer.write("Vowels: " + result[0] + System.lineSeparator());
            writer.write("Consonants: " + result[2] + System.lineSeparator());
            writer.write("Punctuation: " + result[1] + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void countSymbols(String line, int[] result) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        char[] punctualMarks = new char[]{'.', '?', '!', ','};
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (currentChar != ' ') {
                if (checkIfContains(currentChar, vowels)) {
                    result[0]++;
                } else if(checkIfContains(currentChar, punctualMarks)){
                    result[1]++;
                } else {
                    result[2]++;
                }
            }
        }
    }

    private static boolean checkIfContains(char value, char[] values) {
        for (int j = 0; j < values.length; j++) {
            if (values[j] == value) {
                return true;
            }
        }
        return false;
    }
}
