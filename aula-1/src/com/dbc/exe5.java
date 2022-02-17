package com.dbc;

import java.util.Scanner;

public class exe5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Valor da hora: R$ ");
        Float valorHr = scanner.nextFloat();
        System.out.printf("Horas trabalhadas: ");
        Integer hrT = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Horas extras (50%) trabalhadas: ");
        Integer hr50 = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Horas extras (100%) trabalhadas: ");
        Integer hr100 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("");
        Float salario = (float) ((hrT * valorHr) + (hr50 * valorHr * 1.5) + (hr100 * valorHr * 2));
        System.out.printf("Salario bruto: R$ %.2f", salario);
    }
}
