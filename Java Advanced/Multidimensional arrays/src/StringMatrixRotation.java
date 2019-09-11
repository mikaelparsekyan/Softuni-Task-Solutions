import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();//Rotate(90)
        Pattern regex = Pattern.compile("([0-9]+)");
        Matcher matcher = regex.matcher(command);
        int iterations = 0;
        if (matcher.find()) {
            iterations = Integer.parseInt(matcher.group());
        }
        String row = scanner.nextLine();
        List<String> input = new ArrayList<>();
        int index = 0;
        int longestInput = 0;
        while (!"END".equals(row)) {
            input.add(row);
            if (row.length() > longestInput) {
                longestInput = row.length();
            }
            row = scanner.nextLine();
        }
        String[][] matrix = new String[input.size()][longestInput];
        for (int i = 0; i < input.size(); i++) {
            String val = input.get(i);
            String[] elements = new String[longestInput];
            for (int j = 0; j < val.length(); j++) {
                char currentChar = val.charAt(j);
                elements[j] = currentChar + "";
            }
            matrix[i] = elements;
        }
        System.out.println();
        //matrix = rotateMatrix(matrix);
        if (iterations != 0) {


            for (int i = 0; i < iterations / 90; i++) {
                matrix = rotateMatrix(matrix);
            }
        }
        for (String[] strings : matrix) {
            for (String s : strings) {
                if(s!=null) {
                    System.out.print(s + "");
                }
            }
            System.out.println();
        }
    }

    private static String[][] rotateMatrix(String[][] matrix) {
        String[][] newMatrix = new String[findLongestWord(matrix)][];
        for (int i = 0; i < matrix.length; i++) {
            int rowIndex = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                String[] row = new String[matrix.length];
                int index = 0;
                for (int k = matrix.length - 1; k >= 0; k--) {
                    if (matrix[k][j] == null) {
                        matrix[k][j] = " ";
                    }
                    row[index] = matrix[k][j];
                    index++;
                }
                newMatrix[rowIndex] = row;
                rowIndex++;
            }
        }
        return newMatrix;
    }

    private static int findLongestWord(String[][] matrix) {
        int length = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            String[] word = matrix[i];
            if (word != null && word.length > length) {
                length = word.length;
            }
        }
        return length;
    }
}
