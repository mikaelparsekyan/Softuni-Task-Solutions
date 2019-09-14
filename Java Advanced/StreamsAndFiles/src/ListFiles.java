import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String path = "";//file absolute path
        File file = new File(path);
        File[] files = file.listFiles();
        for (File currentFile : files) {
            if (currentFile.isFile()) {
                System.out.printf("%s: [%d]%n", currentFile.getName(), currentFile.length());
            }
        }

    }
}
