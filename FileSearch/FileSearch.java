import java.io.*;
public class FileSearch {
    public static String searchFile(String fileName) {
        File root = new File("documents");
        String result = searchRecursive(root, fileName);
        return result != null ? result : "File not found";
    }
    public static String searchRecursive(File dir, String fileName) {
        if (!dir.isDirectory() || !dir.exists()) {
            return null;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    String result = searchRecursive(file, fileName);
                    if (result != null) {
                        return result;
                    }
                } else if (file.getName().equals(fileName)) {
                    return file.getPath();
                }
            }
        }
        return null;
    }
}