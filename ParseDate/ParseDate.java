import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {
    
    public static LocalDateTime parseIsoFormat(String stringDate) {
        if(stringDate == null || stringDate.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(stringDate, formatter);
    }
    
    public static LocalDate parseFullTextFormat(String stringDate) {
        if(stringDate == null || stringDate.isEmpty()) {
            return null;
        }
        String[] words = stringDate.split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (capitalized.length() > 0) {
                capitalized.append(" ");
            }
            capitalized.append(word.substring(0, 1).toUpperCase())
                      .append(word.substring(1).toLowerCase());
        }
        // System.out.println(capitalized.toString());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.ENGLISH);
        return LocalDate.parse(capitalized.toString(), formatter);
    }
    
    public static LocalTime parseTimeFormat(String stringDate) {
        if(stringDate == null || stringDate.isEmpty()) {
            return null;
        }
        String[] parts = stringDate.split(",");
        
        String hoursPart = parts[0].trim();
        String[] hourTokens = hoursPart.split(" ");
        int hours = Integer.parseInt(hourTokens[0]);
        
        if (hoursPart.contains("evening") || hoursPart.contains("afternoon")) {
            if (hours != 12) {
                hours += 12;
            }
        } else if (hoursPart.contains("morning") && hours == 12) {
            hours = 0;
        }
        
        String minutesPart = parts[1].trim();
        String[] minuteTokens = minutesPart.split(" ");
        int minutes = Integer.parseInt(minuteTokens[0]);
        
        String secondsPart = parts[1].trim();
        String[] secondTokens = secondsPart.split("and");
        String[] secParts = secondTokens[1].trim().split(" ");
        int seconds = Integer.parseInt(secParts[0]);
        
        return LocalTime.of(hours, minutes, seconds);
    }
}