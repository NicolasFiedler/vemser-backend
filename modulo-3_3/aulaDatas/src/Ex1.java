import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String aniversario = scanner.nextLine();

        LocalDate dataAniversario = LocalDate.parse(aniversario, DateTimeFormatter.ofPattern("dd/MM/yyyy")).withYear(LocalDate.now().getYear());
        LocalDate now = LocalDate.now();

        Period period;
        if (dataAniversario.isBefore(now)) {
            System.out.println("isBefore");
            period = Period.between(now, dataAniversario.plusYears(1));
            System.out.println("Restam " + period.getDays() + " dias e " + period.getMonths() + " meses para seu aniversário");

        } else if (dataAniversario.isAfter(now)) {
            System.out.println("isAfter");
            period = Period.between(now, dataAniversario);
            System.out.println("\n Restam " + period.getDays() + " dias e " + period.getMonths() + " meses para seu aniversário");

        } else {
            System.out.println("Feliz aniversario!");
        }
    }
}