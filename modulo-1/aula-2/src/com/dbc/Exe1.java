package com.dbc;

import java.util.Scanner;

public class Exe1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double valor, valorUni, total;

        System.out.printf("Nome do produto: ");
        String produto = scanner.nextLine();
        System.out.printf("Valor: ");
        valor = scanner.nextDouble();

        System.out.println("\n\n\n\n\n\n\n\n\n\n " +
                "Promocao de " + produto + "\n--------------------------");

        for (double i = 1, j = 0.05; i <= 10; i++, j += 0.05) {
            valorUni = valor - (valor * j);
            total = valorUni * i;
            System.out.printf("%.0f x R$ %.2f = %.2f\n", i, valorUni, total);
        }
    }
}
