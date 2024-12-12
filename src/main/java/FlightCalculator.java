import java.time.*;
import java.time.format.DateTimeFormatter;

public class FlightCalculator {

    public static void main(String[] args) {
        // Пример: вылет из Лос-Анджелеса 15:05 PST, длительность 10 часов 50 минут
        String departureTime = "2024-12-10T15:05:00"; // ISO-8601 формат
        String departureZone = "America/Los_Angeles";
        String arrivalZone = "Europe/Berlin";
        long flightHours = 10;
        long flightMinutes = 50;

        String arrivalTime = calculateArrivalTime(departureTime, departureZone, arrivalZone, flightHours, flightMinutes);
        System.out.println("Time of arrival: " + arrivalTime);
    }

    public static String calculateArrivalTime(String departureTime, String departureZone, String arrivalZone, long flightHours, long flightMinutes) {
        // Парсим время вылета и создаём объект ZonedDateTime
        ZonedDateTime departureDateTime = ZonedDateTime.of(LocalDateTime.parse(departureTime), ZoneId.of(departureZone));

        // Добавляем продолжительность полета
        Duration flightDuration = Duration.ofHours(flightHours).plusMinutes(flightMinutes);
        ZonedDateTime arrivalDateTime = departureDateTime.plus(flightDuration).withZoneSameInstant(ZoneId.of(arrivalZone));

        // Форматируем результат в читаемый вид
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
        return arrivalDateTime.format(formatter);
    }
}
