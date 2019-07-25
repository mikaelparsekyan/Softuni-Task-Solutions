import java.util.Scanner;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] elements = input.split(":");
            String artist = elements[0];
            String song = elements[1];
            int length = elements[0].length() % ('z' - 'a' + 1);
            if (checkArtist(elements[0]) && checkSong(elements[1])) {
                System.out.println("Successful encryption: " + encryptString(artist, length) + "@" + encryptString(song, length));
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    static String encryptString(String s, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            char encryptedChar = (char) (currentChar + length);
            if (currentChar != ' ' && currentChar != '\'') {
                if (Character.isLowerCase(currentChar) && encryptedChar > 'z') {
                    encryptedChar = (char) ('a' + (encryptedChar - 'z' - 1));
                }
                if (Character.isUpperCase(currentChar) && encryptedChar > 'Z') {
                    encryptedChar = (char) ('A' + (encryptedChar - 'Z' - 1));
                }

            } else {
                encryptedChar = currentChar;
            }
            result.append(encryptedChar);
        }
        return result.toString();
    }

    static boolean checkArtist(String name) {
        if (Character.isUpperCase(name.charAt(0))) {
            for (int i = 1; i < name.length(); i++) {
                boolean isValid =
                        Character.isLowerCase(name.charAt(i)) ||
                                (name.charAt(i) == ' ') || (name.charAt(i) == '\'');
                if (!isValid) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    static boolean checkSong(String songName) {
        for (int i = 0; i < songName.length(); i++) {
            boolean isValid =
                    Character.isUpperCase(songName.charAt(i)) ||
                            (songName.charAt(i) == ' ');
            if (!isValid) {
                return false;
            }
        }
        return true;
    }
}
