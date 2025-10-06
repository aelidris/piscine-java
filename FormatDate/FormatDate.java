import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {
    
    public static String formatToFullText(LocalDateTime dateTime) {
        // Format: "Le 22 août de l'an 2021 à 13h25m et 46s"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
            "'Le 'dd MMMM 'de l''an 'yyyy 'à 'HH'h'mm'm et 'ss's'",
            Locale.FRENCH
        );
        return formatter.format(dateTime);
    }
    
    public static String formatSimple(LocalDate date) {
        // Format: "febbraio 13 22"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
            "MMMM dd yy",
            Locale.ITALIAN
        );
        return formatter.format(date);
    }
    
    public static String formatIso(LocalTime time) {
        // Format: "16:18:56.008495847"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSSSSS");
        return formatter.format(time);
    }
}