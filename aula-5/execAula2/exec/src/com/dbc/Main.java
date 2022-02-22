package com.dbc;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Soma soma = new Soma();
//        Subtracao subtracao = new Subtracao();
//        Multiplicacao multiplicacao = new Multiplicacao();
//        Divisao divisao = new Divisao();
//
//        Integer a = 3, b = 2;
//
//        System.out.println(soma.calcula(a,b));
//        System.out.println(subtracao.calcula(a,b));
//        System.out.println(multiplicacao.calcula(a,b));
//        System.out.println(divisao.calcula(a,b));

        ArrayList<String> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();

        while (!nome.equalsIgnoreCase("sair")){
            lista.add(nome);
            nome = scanner.nextLine();
        }

        System.out.println(lista.get(lista.size()-2));
        System.out.println(lista.get(0));
        System.out.println(lista.remove(lista.size()-1));
        System.out.println(lista);
        System.out.println("Sobraram " + lista.size() + " nomes.");
    }
}
