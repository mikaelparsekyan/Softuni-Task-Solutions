import java.util.*;

public class TreasureFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] keys = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String stringToEncrypt = scanner.nextLine();
        int keyIndex = 0;

        while (!"find".equals(stringToEncrypt)) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < stringToEncrypt.length(); i++) {

                result.append((char) (stringToEncrypt.charAt(i) - keys[keyIndex]));

                if (keyIndex >= keys.length - 1) {
                    keyIndex = 0;
                } else {
                    keyIndex++;
                }
            }
            String resultToString = result.toString();

            int materialStartIndex = resultToString.indexOf("&")+1;
            int materialEndIndex = resultToString.indexOf("&", materialStartIndex + 1);
            int coordinatesStartIndex = resultToString.indexOf("<")+1;
            int coordinatesEndIndex = resultToString.indexOf(">");
            String material = resultToString.substring(materialStartIndex,materialEndIndex);
            String coordinates = resultToString.substring(coordinatesStartIndex,coordinatesEndIndex);

            System.out.printf("Found %s at %s\n",material,coordinates);
            stringToEncrypt = scanner.nextLine();
            keyIndex = 0;
        }
    }
}


