import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Ex6 {
    public static void main(String[] args) {

        LocalDateTime show = LocalDateTime.of(2024, 9, 14, 18, 30);
        ZoneId zoneId = ZoneId.of("UTC+01:00");
        ZonedDateTime zonedEU = ZonedDateTime.of(show, zoneId);

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime horaTemporariaEx6 = LocalDateTime.from(now);

        long anos = horaTemporariaEx6.until(zonedEU, ChronoUnit.YEARS);
        horaTemporariaEx6 = horaTemporariaEx6.plusYears(anos);
        long meses = horaTemporariaEx6.until(zonedEU, ChronoUnit.MONTHS);
        horaTemporariaEx6 = horaTemporariaEx6.plusMonths(meses);
        long dias = horaTemporariaEx6.until(zonedEU, ChronoUnit.DAYS);
        horaTemporariaEx6 = horaTemporariaEx6.plusDays(dias);
        long horas = horaTemporariaEx6.until(zonedEU, ChronoUnit.HOURS);
        horaTemporariaEx6 = horaTemporariaEx6.plusHours(horas);
        long minutos = horaTemporariaEx6.until(zonedEU, ChronoUnit.MINUTES);
        horaTemporariaEx6 = horaTemporariaEx6.plusMinutes(minutos);
        long segundos = horaTemporariaEx6.until(zonedEU, ChronoUnit.SECONDS);

        System.out.println("Anos: " + anos);
        System.out.println("Meses: " + meses);
        System.out.println("Dias: " + dias);
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);
    }

}
