package com.dbc;

import java.util.Scanner;

public class exe5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer hrT, hr50, hr100;

        System.out.print("Valor da hora: R$ ");
        Double valorHr = scanner.nextDouble();
        System.out.print("Horas trabalhadas: ");
        hrT = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Horas extras (50%) trabalhadas: ");
        hr50 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Horas extras (100%) trabalhadas: ");
        hr100 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("");
        Double salario = ((hrT * valorHr) + (hr50 * valorHr * 1.5) + (hr100 * valorHr * 2));
        System.out.printf("Salario bruto: R$ %.2f", salario);
    }
}
