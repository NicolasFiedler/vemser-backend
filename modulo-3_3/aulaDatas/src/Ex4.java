import java.time.LocalDateTime;

public class Ex4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().plusDays(15).plusHours(10);

        System.out.println("Dia da semana: " + now.getDayOfWeek());
        System.out.println("Dia do ano: " + now.getDayOfYear());
    }
}
