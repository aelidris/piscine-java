public class CleanExtract {
    public static String extract(String s) {
        String[] substrings = s.split("\\|");
        // return Arrays.toString(substrings);
        StringBuilder result = new StringBuilder();
        for (String sub : substrings) {
            boolean canAddSub = false;
            boolean isPoint = false;
            String cleanSub = sub.trim();
            int count = cleanSub.length() - cleanSub.replace(".", "").length();
            if (!cleanSub.contains(".")) {
                result.append(cleanSub + " ");
            } else {
                StringBuilder word = new StringBuilder();
                char prevChar = '\0';
                for (char c : cleanSub.toCharArray()) {
                    if ((c == '.' && Character.isAlphabetic(prevChar) && count>2) || (!isPoint && c == '.' && prevChar == '.' && count>2)) {
                        word.append(c);
                        isPoint = true;
                    }
                    if (canAddSub && c != '.') {
                        word.append(c);
                    }
                    if (c == '.') {
                        canAddSub = true;
                        
                    }
                    prevChar = c;

                }
                result.append(word + " ");
            }
        }
        return result.toString().replaceAll("\\s+", " ").trim();
    }
}

// System.out.println(CleanExtract.extract("The|. quick brown. | what do you ..| .fox .|. Jumps over the lazy dog. ."));
// The quick brown fox Jumps over the lazy dog.

// System.out.println(CleanExtract.extract("  | Who am .I  | .love coding,  |  |.  Coding is fun . | ...  "));
// I love coding, Coding is fun .