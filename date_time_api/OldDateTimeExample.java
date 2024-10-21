package date_time_api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class OldDateTimeExample {
    public static void main(String[] args) {
        // Create a new date object (current date)
        Date currentDate = new Date();
        System.out.println("Current Date: " + currentDate);

        // Using Calendar to create and manipulate dates
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.MAY); // May (zero-based)
        calendar.set(Calendar.DAY_OF_MONTH, 5);
        Date specificDate = calendar.getTime();
        System.out.println("Specific Date (May 5, 2023): " + specificDate);

        // Adding days to a date using Calendar
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date futureDate = calendar.getTime();
        System.out.println("Future Date (10 days later): " + futureDate);

        // Formatting a date using SimpleDateFormat
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormatter.format(currentDate);
        System.out.println("Formatted Current Date: " + formattedDate);

        // Parsing a string into a date
        String dateStr = "05-05-2023";
        try {
            Date parsedDate = dateFormatter.parse(dateStr);
            System.out.println("Parsed Date: " + parsedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Handling time zones using Calendar and TimeZone
        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        calendar.setTimeZone(utcTimeZone);
        System.out.println("Current Time in UTC: " + calendar.getTime());

        TimeZone nyTimeZone = TimeZone.getTimeZone("America/New_York");
        calendar.setTimeZone(nyTimeZone);
        System.out.println("Current Time in New York: " + calendar.getTime());
    }
}

