package com.spring.project.spring.bookshop.util;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class FileUtilImpl implements FileUtil {
    @Override
    public String[] readFile(String path) {
        File file = new File(path);
        Set<String> result = new LinkedHashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = reader.readLine();

            while (line != null) {
                if (!isLineEmpty(line)) {
                    result.add(line);
                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("No file found.");
        }
        return setToArray(result);
    }

    private String[] setToArray(Set<String> set) {
        String[] res = new String[set.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = set.toArray()[i] + "";
        }
        return res;
    }

    private boolean isLineEmpty(String line) {
        return line.trim().isEmpty();
    }
}
