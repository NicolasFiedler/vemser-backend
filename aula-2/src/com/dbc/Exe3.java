package com.dbc;

import java.util.Scanner;

public class Exe3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome, nomeAlturaMaior = null, nomeIdadeMaior = null, nomePesoMaior = null;
        Double altura, alturaMaior = 0., peso, pesoMaior = 0., somaAltura = 0.;
        Integer idade, idadeMaior = 0, cont = 0;

        do {
            System.out.printf("Informe o nome do jogador: ");
            nome = scanner.nextLine();
            if(nome.equalsIgnoreCase("sair")){
                break;
            }
            System.out.printf("Informe a altura do jogador: ");
            altura = scanner.nextDouble();
            scanner.nextLine();
            System.out.printf("Informe a idade do jogador: ");
            idade = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("Informe o peso do jogador: ");
            peso = scanner.nextDouble();
            scanner.nextLine();

            cont++;
            somaAltura += altura;
            if (idade > idadeMaior) {
                idadeMaior = idade;
                nomeIdadeMaior = nome;
            }
            if (altura > alturaMaior){
                alturaMaior = altura;
                nomeAlturaMaior = nome;
            }
            if (peso > pesoMaior){
                pesoMaior = peso;
                nomePesoMaior = nome;
            }
            System.out.println("\n\n");
        } while (true);
        System.out.println("Jogadores cadastrados: " + cont);
        System.out.println("Jogador mais alto: " + nomeAlturaMaior + " - " + alturaMaior);
        System.out.println("jogador mais velho: " + nomeIdadeMaior + " - " +idadeMaior);
        System.out.println("Jogador mais pesado" + nomePesoMaior+ " - " + pesoMaior);
        System.out.println("Media de altura dos jogadores: " + somaAltura / cont);
    }
}
