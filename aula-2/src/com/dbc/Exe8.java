package com.dbc;

import java.util.Scanner;

public class Exe8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MATRICULA = 0, PROVA = 1, TRABALHO = 2, FINAL = 3;
        double[][] table = new double[5][4];

        for (int i = 0; i < 5; i++) {
            System.out.printf("Informe matricula: ");
            table[i][MATRICULA] = scanner.nextDouble();
            scanner.nextLine();
            System.out.printf("Informe nota da prova: ");
            table[i][PROVA] = scanner.nextDouble();
            scanner.nextLine();
            System.out.printf("Informe nota do trabalho: ");
            table[i][TRABALHO] = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("\n");
        }
    }
}
