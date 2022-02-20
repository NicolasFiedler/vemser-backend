package com.dbc;

public class Endereco {
    public Integer tipo, numero;
    public String logradouro, pais, estado, cidade, cep, complemento = "";

    public void imprimirEndereco(){                        //"Contato.java:5:49"
        if (!complemento.equals("")) {
            System.out.printf("Endereco: \n%s, %d.\nComplemento: %s.\n", logradouro, numero, complemento);
            System.out.printf("%s, %s, %s, %s.\n", cidade, estado, cep, pais);
        } else {
            System.out.printf("Endereco: %s, %d.\n", logradouro, numero);
            System.out.printf("%s, %s, %s, %s.\n", cidade, estado, cep, pais);
        }
        if (tipo == null){
        } else if (tipo == 1){
            System.out.println("Endereco residencial.");
        } else if (tipo == 2) {
            System.out.println("Endereco comercial.");
        }
        System.out.println("");
    }
}