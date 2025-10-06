import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        // Format: "Le 22 août de l'an 2021 à 13h25m et 46s"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "'Le 'dd MMM.' de l''an 'yyyy 'à 'HH'h'mm'm et 'ss's'",
                Locale.FRENCH);
        return formatter.format(dateTime);
    }

    public static String formatSimple(LocalDate date) {
        if (date == null) {
            return null;
        }
        // Format: "febbraio 13 22"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "MMMM dd yy",
                Locale.ITALIAN);
        return formatter.format(date);
    }

    public static String formatIso(LocalTime time) {
        if (time == null) {
            return null;
        }
        String s;
        DateTimeFormatter formatter;
        // System.out.println(time);
        if (time.toString().contains("\\.")) {
            int numberOfS = time.toString().split("\\.")[1].length();
            s = "S".repeat(numberOfS);
            formatter = DateTimeFormatter.ofPattern("HH:mm:ss." + s);
        } else {
            formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        }
        return formatter.format(time);
    }
}