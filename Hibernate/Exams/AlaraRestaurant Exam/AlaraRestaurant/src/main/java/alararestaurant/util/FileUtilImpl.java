package alararestaurant.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtilImpl implements FileUtil {
    public String readFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
