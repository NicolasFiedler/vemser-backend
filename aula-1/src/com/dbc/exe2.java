package com.dbc;

import java.util.Scanner;

public class exe2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Float nota = 0f;

        System.out.print("Nota 1: ");
        nota += scanner.nextFloat();
        System.out.print("Nota 2: ");
        nota += scanner.nextFloat();
        System.out.print("Nota 3: ");
        nota += scanner.nextFloat();
        System.out.print("Nota 4: ");
        nota += scanner.nextFloat();
        nota /= 4;

        if (nota >= 0 && nota <= 5){
            System.out.printf("%.1f - Reprovado.\n", nota);
        }else if (nota > 5 && nota < 7){
            System.out.printf("%.1f - Em exame.\n", nota);
        }else if (nota >= 7 && nota <= 10){
            System.out.printf("%.1f - Aprovado!\n", nota);
        }else {
            System.out.println("!VALORES INVALIDOS!");
        }
    }
}
