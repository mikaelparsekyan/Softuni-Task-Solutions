import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NestedFolders {

    public static void main(String[] args) {
        String path = "";//file absolute path
        File mainFile = new File(path);
        AtomicInteger counter = new AtomicInteger(0);
        listFiles(mainFile, new ArrayDeque<>(),counter);
        System.out.println(counter + " folders");
    }

    private static void listFiles(File file,Queue<File> fileQueue,AtomicInteger counter) {

        File[] files = file.listFiles();
        if (files != null) {
            for (File currentFile : files) {
                if(currentFile.isDirectory()){
                    fileQueue.add(currentFile);
                    counter.addAndGet(1);
                }
            }
            while (fileQueue.size()>0){
                File f  = fileQueue.poll();
                System.out.println(f.getName());
                listFiles(f,fileQueue,counter);
            }
        }
    }
}
