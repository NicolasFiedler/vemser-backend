import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Date date = new Date(1995 - 1900,12 - 1,30,10,15);

        System.out.println(date);

        System.out.println();
        System.out.println();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        date = simpleDateFormat.parse(str);

        System.out.println(date);
        System.out.println(simpleDateFormat.format(date));
    }
}
