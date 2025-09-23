import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) {
            return;
        }
        String inputFile = args[0];
        String outputFile = args[1];

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // System.out.println("DEBUG: line = [" + line + "]");
                line = line.trim().replaceAll("\\s+", " ");
                // System.out.println("DEBUG: line = [" + line + "]");
                if (line.isEmpty()){
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                boolean capitalizeNext = true;
                for (char c : line.toCharArray()) {
                    if (c == ' ') {
                        capitalizeNext = true;
                        sb.append(c);
                    } else if (capitalizeNext) {
                        if (Character.isAlphabetic(c)) {
                            sb.append(Character.toUpperCase(c));
                        } else {
                            sb.append(c);
                        }
                        capitalizeNext = false;
                    } else {
                        sb.append(c);
                    }
                }
                // System.out.println("DEBUG: line = [" + sb + "]");
                writer.write(sb.toString());
                writer.newLine();
            }
        }
    }
}
