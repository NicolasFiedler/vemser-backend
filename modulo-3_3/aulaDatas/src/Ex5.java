import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Ex5 {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        System.out.println("Brasileiro: " + now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("pt-BR"))));
        System.out.println("Estado Unidense: " + now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("en"))));
        System.out.println("Francês: " + now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("fr"))));
    }
}
