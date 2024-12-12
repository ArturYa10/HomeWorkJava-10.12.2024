import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JavaClassSchedule {
    public static void main(String[] args) {
        // Initial settings
        LocalDate startDate = LocalDate.of(2024, 12, 1); // start of the month
        LocalDate endDate = LocalDate.of(2024, 12, 31);  // end of the month
        DayOfWeek[] classDays = {DayOfWeek.TUESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY};
        LocalTime classTime = LocalTime.of(9, 30); // class start time

        // Date and time format for output
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy, HH:mm z");
        ZoneId zone = ZoneId.of("CET"); // time zone

        // List to store class dates
        List<ZonedDateTime> schedule = new ArrayList<>();

        // Iterate through December 2024 dates
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (Arrays.asList(classDays).contains(date.getDayOfWeek())) {
                schedule.add(ZonedDateTime.of(date, classTime, zone));
            }
        }

        // Print the schedule
        System.out.println("Java Class Schedule for December 2024:");
        for (ZonedDateTime dateTime : schedule) {
            System.out.println(dateTime.format(formatter));
        }
    }
}
