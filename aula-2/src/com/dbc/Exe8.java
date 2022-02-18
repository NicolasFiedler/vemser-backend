package com.dbc;

import java.util.Scanner;

public class Exe8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MATRICULA = 0, PROVA = 1, TRABALHO = 2, NOTA_FINAL = 3;
        double maior = 0, matriculoMaior = 0, media = 0;
        int i;
        double[][] table = new double[5][4];

        for (i = 0; i < 5; i++) {
            System.out.printf("Informe matricula: ");
            table[i][MATRICULA] = scanner.nextDouble();
            scanner.nextLine();
            System.out.printf("Informe nota da prova: ");
            table[i][PROVA] = scanner.nextDouble();
            scanner.nextLine();
            System.out.printf("Informe nota do trabalho: ");
            table[i][TRABALHO] = scanner.nextDouble();
            scanner.nextLine();

            table[i][NOTA_FINAL] = (table[i][PROVA] * 0.6) + (table[i][TRABALHO] * 0.4);

            if (i == 0){
                maior = table[i][NOTA_FINAL];
                matriculoMaior = table[i][MATRICULA];
            }else if (table[i][NOTA_FINAL] > maior){
                maior = table[i][NOTA_FINAL];
                matriculoMaior = table[i][MATRICULA];
            }

            media += table[i][NOTA_FINAL];

            System.out.println("\n");
        }

        System.out.printf("\nMatricula com maior nota: %.0f \nCom: %.2fn\n", matriculoMaior, maior);
        System.out.printf("Media das notas: %.2f", media / i);
    }
}
