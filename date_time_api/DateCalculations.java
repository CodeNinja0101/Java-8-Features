package date_time_api;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateCalculations {
    public static void main(String[] args) {

        // Current date and time
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        LocalDate futureDate = today.plusDays(10);
        System.out.println("10 days later Date: " + futureDate);

        // Period between two dates
        Period period = Period.between(today, futureDate);
        System.out.println("Period between today's date and future date: " + period.getDays() + " days");


        // Duration between two times
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = now.plusHours(1).plusMinutes(30);
        Duration duration = Duration.between(now, later);
        System.out.println("Duration between now and 2 hours 30 minutes later: " + duration.toMinutes() + " minutes");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Print the current time and the later time
        System.out.println("Current time: " + now.format(formatter));
        System.out.println("Time after 1 hours and 30 minutes: " + later.format(formatter));
    }
}
