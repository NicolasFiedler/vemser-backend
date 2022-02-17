package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class exe6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Informe uma palavra: ");
        String palavra = scanner.nextLine();
        System.out.println("");

        switch (palavra.toLowerCase(Locale.ROOT)){
            case "cachorro":
                System.out.println(palavra + " = Dog");
                break;
            case "tempo":
                System.out.println(palavra + " = Time");
                break;
            case "amor":
                System.out.println(palavra + " = Love");
                break;
            case "cidade":
                System.out.println(palavra + " = City");
                break;
            case "feliz":
                System.out.println(palavra + " = Happy");
                break;
            default:
                System.out.printf("Palavra '%s' nao encontrada\n", palavra);
        }
    }
}
