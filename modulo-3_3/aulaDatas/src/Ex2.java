import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data1 = scanner.nextLine();
        String data2 = scanner.nextLine();

        LocalDate localDate1 = LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate localDate2 = LocalDate.parse(data2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (localDate1.isBefore(localDate2)) {
            System.out.println("dias: " + ChronoUnit.DAYS.between(localDate1, localDate2));
            System.out.println("meses: " + ChronoUnit.MONTHS.between(localDate1, localDate2));
            System.out.println("anos: " + ChronoUnit.YEARS.between(localDate1, localDate2));
        } else {
            System.out.println("dias: " + ChronoUnit.DAYS.between(localDate2, localDate1));
            System.out.println("meses: " + ChronoUnit.MONTHS.between(localDate2, localDate1));
            System.out.println("anos: " + ChronoUnit.YEARS.between(localDate2, localDate1));
        }
    }
}
