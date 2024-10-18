package date_time_api;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeZonesAndZonedDateTime {
    public static void main(String[] args) {
        // Current time in UTC
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("Current time in UTC: " + utcTime);

        // Convert UTC to another time zone
        ZonedDateTime nyTime = utcTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Current time in New York: " + nyTime);

        // Formatting zoned date-time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm z");
        String formattedDateTime = nyTime.format(formatter);
        System.out.println("Formatted DateTime in New York: " + formattedDateTime);

    }
}

