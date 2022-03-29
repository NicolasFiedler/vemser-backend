import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Ex6 {
    public static void main(String[] args) {

        LocalDateTime show = LocalDateTime.of(2024, 9, 14, 18, 30);
        ZoneId zoneId = ZoneId.of("UTC+01:00");
        ZonedDateTime zonedEU = ZonedDateTime.of(show, zoneId);

        LocalDateTime now = LocalDateTime.now();
        ZoneId zoneIdBR = ZoneId.of("UTC-03:00");
        ZonedDateTime zonedBR = ZonedDateTime.of(now, zoneIdBR);

        System.out.println("Dias: " + ChronoUnit.DAYS.between(zonedBR, zonedEU));
        System.out.println("Meses: " + ChronoUnit.MONTHS.between(zonedBR, zonedEU));
        System.out.println("Anos: " + ChronoUnit.YEARS.between(zonedBR, zonedEU));
        System.out.println("Horas: " + ChronoUnit.HOURS.between(zonedBR, zonedEU));
        System.out.println("Minutos: " + ChronoUnit.MINUTES.between(zonedBR, zonedEU));
        System.out.println("Segundos: " + ChronoUnit.SECONDS.between(zonedBR, zonedEU));
    }

}
