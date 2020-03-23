package com.example.demo.util;

import java.io.*;

public class FileUtil {
    public static String readFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(new File(path)));
            StringBuilder fileBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileBuilder.append(line);
            }
            return fileBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write(String path, String value) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            fileWriter.write(value);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
