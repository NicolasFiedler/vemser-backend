package com.dbc;

import java.util.Scanner;

public class Exe5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vet = new int[20];

        for (int i = 0; i < vet.length; i++) {
            vet[i] = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("");
        for (int i = vet.length - 1; i >= 0; i--) {
            System.out.println(vet[i]);
        }
    }
}
