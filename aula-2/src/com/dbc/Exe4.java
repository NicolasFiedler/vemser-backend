package com.dbc;

import java.util.Scanner;

public class Exe4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer i, menor;
        int[] vet =  new int[3];

        vet[0] = scanner.nextInt();
        scanner.nextLine();
        menor = vet[0];

        for ( i = 1; i < 3; i++) {
            vet[i] = scanner.nextInt();
            scanner.nextLine();
            if (vet[i] < vet[i-1]){
                menor = i;
            }
        }

        System.out.println("O menor numero esta na casa "+ menor +", sendo " + vet[menor]);
    }
}
