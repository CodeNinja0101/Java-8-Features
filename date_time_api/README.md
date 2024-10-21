New Date and Time API (java.time)
Overview

This section focuses on Java 8's new date and time API (java.time), which simplifies working with dates, times, durations, and time zones. It provides more consistent and thread-safe handling compared to the old java.util.Date and java.util.Calendar classes.

The new API includes immutable classes like LocalDate, LocalTime, LocalDateTime, ZonedDateTime, Period, and Duration, which make handling time-related functionality much more intuitive.
Key Classes and Methods

    LocalDate:
        Represents a date (year, month, day) without time.
        Example:

    LocalDate today = LocalDate.now();
    LocalDate birthday = LocalDate.of(1990, Month.MARCH, 5);

    Key Methods:
        now(): Get the current date.
        plusDays(int days), minusWeeks(int weeks): Modify dates.
        isBefore(), isAfter(): Compare dates.

LocalTime:

    Represents a time (hours, minutes, seconds) without a date.
    Example:

    LocalTime currentTime = LocalTime.now();
    LocalTime specificTime = LocalTime.of(10, 30);

    Key Methods:
        now(): Get the current time.
        plusHours(int hours): Modify time.

LocalDateTime:

    Combines LocalDate and LocalTime to represent both date and time.
    Example:

    LocalDateTime currentDateTime = LocalDateTime.now();

    Key Methods:
        plusMinutes(), minusDays(): Modify the date/time.

ZonedDateTime:

    Represents a date and time with time zone information.
    Example:

    ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/New_York"));

    Key Methods:
        now(ZoneId zoneId): Get the current date and time in a specific time zone.

Period:

    Represents a period of time in terms of years, months, and days.
    Example:

    Period period = Period.between(LocalDate.of(2020, 1, 1), LocalDate.now());

    Key Methods:
        between(): Calculate the period between two dates.

Duration:

    Represents a period of time in terms of seconds and nanoseconds.
    Example:

        Duration duration = Duration.ofHours(2);

        Key Methods:
            ofHours(), ofMinutes(): Create a duration.

Methods & Usages

    Parsing and Formatting: The new API includes support for parsing and formatting dates using DateTimeFormatter.
        Example:

    LocalDate date = LocalDate.parse("2023-05-05");
    String formattedDate = date.format(DateTimeFormatter.ISO_DATE);

Date Manipulation: Use methods like plusDays(), minusWeeks(), plusMonths() to modify date and time.

    Example:

    LocalDate newDate = LocalDate.now().plusDays(5);

Comparisons: Compare two dates/times using isBefore() and isAfter().

    Example:

        if (date1.isBefore(date2)) {
            System.out.println("Date1 is earlier.");
        }

Key Advantages

    Immutable Objects: Classes like LocalDate and LocalDateTime are immutable, ensuring thread safety.
    Better API Design: The API is consistent and more readable than the old Date/Calendar.
    Time Zone Support: Handling time zones with ZonedDateTime is much easier and more accurate.

Rules and Important Concepts

    Immutability: All classes in java.time are immutable, meaning they cannot be modified after creation. Instead, any operation (like adding days) returns a new instance.
    Thread-Safety: Since these classes are immutable, they are inherently thread-safe, unlike java.util.Date and Calendar.
    Avoid Nulls: With the new API, null is rarely used. You should rely on Optional and exceptions to handle missing or invalid data.
    Compatibility with Legacy Code: You can convert between the old date/time classes (java.util.Date) and the new API using utility methods like Date.from() or new Date().

Practice Examples

    Parse and Format Dates: Parse a date string and format it for API responses.

LocalDate parsedDate = LocalDate.parse("2023-10-07");
String formattedDate = parsedDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

Calculate Durations: Calculate the duration between two times, such as booking or event times.

LocalDate startDate = LocalDate.of(2023, 10, 1);
LocalDate endDate = LocalDate.now();
Period periodBetween = Period.between(startDate, endDate);
System.out.println("Days between: " + periodBetween.getDays());

Handle Time Zones: Use ZonedDateTime to handle global scheduling.

    ZonedDateTime meetingTimeInNY = ZonedDateTime.now(ZoneId.of("America/New_York"));

Why Move to the New API?

Before Java 8, handling dates and times was difficult to handle or manage due to:

    Mutability: Date and Calendar were mutable, which caused issues in multi-threaded environments.
    Poor API Design: The API was inconsistent and unintuitive, with many issues around time zones and formatting.
    Thread Safety: SimpleDateFormat was not thread-safe, leading to potential bugs when shared between threads.

With Java 8's new API:

    Cleaner Code: The API is simpler and more intuitive.
    Thread Safety: The new classes are immutable and safe to use across multiple threads.
    Time Zone Handling: Time zone handling is much more straightforward with ZonedDateTime.