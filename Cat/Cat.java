import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        String filename = args[0];
        byte[] content = Files.readAllBytes(Paths.get(filename));
        System.out.write(content);
    }
}