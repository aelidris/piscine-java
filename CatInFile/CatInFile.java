import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        String filename = args[0];
        try (OutputStream out = new FileOutputStream(filename)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = System.in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}