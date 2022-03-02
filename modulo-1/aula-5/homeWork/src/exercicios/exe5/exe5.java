package exercicios.exe5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exe5 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        for (int i = 10; i < 50; i++) {
            map.put("123.123.123-" + i, "Pessoa " + (i - 10));
        }

        String cpf = new Scanner(System.in).nextLine();
        if (map.get(cpf) != null){
            System.out.println(map.remove(cpf) + " removida\n");
        } else {
            System.out.println("O cpf nao existe\n");
        }

        System.out.println(map);

    }
}
