package com.dbc;

import java.util.Scanner;

public class Exe7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] mat = new int[4][4];
        int cont = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mat[i][j] = scanner.nextInt();
                scanner.nextLine();
                if (mat[i][j] > 10){
                    cont++;
                }
            }
        }

        System.out.println("Tem "+ cont +" numero maiores que 10");
    }
}
