import java.util.*;

public class ExcelFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[rows - 1][];
        String[] header = scanner.nextLine().split(", ");
        for (int i = 0; i < matrix.length; i++) {
            String[] inputRow = scanner.nextLine().split(", ");
            matrix[i] = inputRow;
        }

        String[] input = scanner.nextLine().split(" ");
        String command = input[0];
        String field = input[1];

        int commandCol = getCol(header, field);


        switch (command) {
            case "hide":
                header = hideColumn(matrix, header, field, commandCol);
                break;

            case "sort":
                matrix = Arrays.stream(matrix)
                        .sorted(Comparator.comparing(a -> a[commandCol]))
                        .toArray(String[][]::new);
                break;

            case "filter":
                String value = input[2];
                matrix = Arrays.stream(matrix)
                        .filter(e -> e[commandCol].equals(value))
                        .toArray(String[][]::new);
                break;
        }
        print(header, matrix);
    }

    private static String[] hideColumn(String[][] matrix, String[] header, String field, int commandCol) {
        List<String> headerList = new LinkedList<>();
        for (String s : header) {
            if (!s.equals(field)) {
                headerList.add(s);
            }
        }
        header = new String[header.length - 1];
        for (int i = 0; i < header.length; i++) {
            header[i] = headerList.get(i);
        }

        for (int i = 0; i < matrix.length; i++) {
            List<String> rowList = new LinkedList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (j != commandCol) {
                    rowList.add(matrix[i][j]);
                }
            }
            matrix[i] = new String[matrix[i].length - 1];
            for (int j = 0; j < rowList.size(); j++) {
                matrix[i][j] = rowList.get(j);
            }

        }
        return header;
    }

    private static int getCol(String[] header, String element) {
        for (int i = 0; i < header.length; i++) {
            if (header[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private static void print(String[] header, String[][] matrix) {
        System.out.println(String.join(" | ", header));
        for (String[] row : matrix) {
            System.out.println(String.join(" | ", row));
        }
    }
}
