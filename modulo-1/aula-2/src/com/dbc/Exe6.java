package com.dbc;

import java.util.Scanner;

public class Exe6 {
    public static void main(String[] args) {
        int[] vet = new int[10];
        Boolean flag = false;
        Integer busca;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < vet.length; i++) {
            vet[i] = i + 10;
        }

        busca = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < vet.length; i++) {
            if(busca == vet[i]){
                flag = true;
            }
        }

        if(flag){
            System.out.println("Numero encontrado!");
        }else {
            System.out.println("Numero nao encontrado");
        }
    }
}
