package sk.uniza.feit.site.utills;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeConverter {
    public static String getString(LocalDateTime input) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/M/d HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(input.format(inputFormatter), inputFormatter);
        return dateTime.format(outputFormatter);
    }
}
