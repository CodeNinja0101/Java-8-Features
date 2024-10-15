package date_time_api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParsingAndFormatting {
    public static void main(String[] args) {

        // Parsing
        String startDate = "2024-10-01";
        LocalDate parsedDate = LocalDate.parse(startDate);
        System.out.println("Parsed LocalDate: " + parsedDate);

        String dateTimeStr = "2024-10-01T10:15";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeStr);
        System.out.println("Parsed LocalDateTime: " + parsedDateTime);

        // Formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = parsedDate.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = parsedDateTime.format(dateTimeFormatter);
        System.out.println("Formatted DateTime: " + formattedDateTime);
    }

}
