import java.io.*;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        // try prevents resource leaks by automatically closing the writer
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        }
    }

    public static String getContentFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        // Remove the last line separator if file is not empty
        if (sb.length() > 0) {
            sb.setLength(sb.length() - System.lineSeparator().length());
        }
        return sb.toString();
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}