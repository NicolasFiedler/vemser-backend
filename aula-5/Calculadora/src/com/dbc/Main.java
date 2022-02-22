package com.dbc;

public class Main {

    public static void main(String[] args) {
        Soma soma = new Soma();
        Subtracao subtracao = new Subtracao();
        Multiplicacao multiplicacao = new Multiplicacao();
        Divisao divisao = new Divisao();

        Integer a = 3, b = 2;

        System.out.println(soma.calcula(a,b));
        System.out.println(subtracao.calcula(a,b));
        System.out.println(multiplicacao.calcula(a,b));
        System.out.println(divisao.calcula(a,b));
    }
}
