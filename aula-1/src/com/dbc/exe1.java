package com.dbc;

import java.util.Scanner;

public class exe1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome, cidade, estado;
        Integer idade;

        System.out.print("Informe seu nome: ");
        nome = scanner.nextLine();
        System.out.print("Informe sua idade: ");
        idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Informe sua cidade: ");
        cidade = scanner.nextLine();
        System.out.print("Informe seu estado: ");
        estado = scanner.nextLine();

        System.out.println(" Olá seu nome é  "+ nome +", você tem "+ idade +" anos, é da cidade de "+ cidade +", situada no estado de "+ estado +".");
    }
}
