package com.dbc;

import java.util.Scanner;

public class Exe2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer numMagico, chute;

        System.out.printf("Informe o numero magico: ");
        numMagico = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        do {
            System.out.printf("Chute um numero: ");
            chute = scanner.nextInt();
            scanner.nextLine();
            if (chute != numMagico){
                if (chute > numMagico){
                    System.out.println("O numero a ser enconcotrado eh MENOR do que voce digitou");
                }else{
                    System.out.println("O numero a ser enconcotrado eh MAIOR do que voce digitou");
                }
            }
            System.out.println("\n\n");
        }while (chute != numMagico);

        System.out.println("Parabens, voce descobriu o Numero Magico!");
    }
}
