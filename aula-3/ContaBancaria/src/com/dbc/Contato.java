package com.dbc;

public class Contato {
    public String descricao, telefone;
    public Integer tipo;                        //Estava eu pensando num ternario pra deixar td em uma linha...
                                                //Quando entao ouvi uma misterisa voz em minha cabeca,
    public void imprimirContato(){              //e ela diza: "nao faca isso, se colega vai querer te matar".
        if (tipo == 1) {
            System.out.printf("Telefone: %s\nContato: Residencial\nDescricao: %s\n\n", telefone, descricao);
        }else if (tipo == 2){
            System.out.printf("Telefone: %s\nContato: Comercial\nDescricao: %s\n\n", telefone, descricao);
        }
    }
}
