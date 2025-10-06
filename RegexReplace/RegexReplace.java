import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {
    public static String removeUnits(String s) {
        String[] patterns = s.split(" ");
        for (String pattern : patterns) {
            if (pattern.matches("^[0-9]+(cm|€)")) {
                s = s.replace(pattern, pattern.replaceAll("(cm|€)", ""));
            }
        }
        return s;
    }

    public static String obfuscateEmail(String s) {
        String[] parts = s.split("@");
        
        if (parts.length != 2) {
            return s; 
        }
        
        String username = parts[0];
        String domain = parts[1];
        
        String obfuscatedUsername = obfuscateUsername(username);
        String obfuscatedDomain = obfuscateDomain(domain);
        
        return obfuscatedUsername + "@" + obfuscatedDomain;
    }

    private static String repeatStar(int count) {
        if (count <= 0) return "";
        return "*".repeat(count);
    }

    private static String obfuscateUsername(String username) {
        
        Pattern separatorPattern = Pattern.compile("[._-]");
        Matcher matcher = separatorPattern.matcher(username);
        
        if (matcher.find()) {
            int firstSeparatorIndex = matcher.start();
            String prefix = username.substring(0, firstSeparatorIndex + 1);
            int hiddenLength = username.length() - prefix.length();
            return prefix + repeatStar(hiddenLength);
        } else {
            if (username.length() > 3) {
                String prefix = username.substring(0, 3);
                int hiddenLength = username.length() - 3;
                return prefix + repeatStar(hiddenLength);
            } else {
                return username;
            }
        }
    }

    private static String obfuscateDomain(String domain) {
        String[] domainParts = domain.split("\\.");
        
        if (domainParts.length == 2) {
            String sld = domainParts[0];
            String tld = domainParts[1];
            
            String obfuscatedSld = repeatStar(sld.length());
            String obfuscatedTld;
            
            if (tld.equals("com") || tld.equals("org") || tld.equals("net")) {
                obfuscatedTld = tld;
            } else {
                obfuscatedTld = repeatStar(tld.length());
            }
            
            return obfuscatedSld + "." + obfuscatedTld;
            
        } else if (domainParts.length > 2) {
            
            StringBuilder sb = new StringBuilder();
            
            sb.append(repeatStar(domainParts[0].length()));
            
            for (int i = 1; i < domainParts.length - 1; i++) {
                sb.append(".").append(domainParts[i]);
            }
            
            sb.append(".").append(repeatStar(domainParts[domainParts.length - 1].length()));
            
            return sb.toString();

        } else {
            return repeatStar(domain.length());
        }
    }
    
}

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// 32 et 50
// 32 cm et 50 €
// 32cms et 50€!
// l lapin jou à la bel ball avec d animau rigolo pour gagner l bill bleu
// john.***@*******.com
// jan*@*******.co.***
// jac***@*******.**
// $