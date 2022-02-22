package com.dbc;

public class Contato {

    public Contato(){}
    public Contato(String telefone, Integer tipo, String descricao){
        this.telefone = telefone;
        this.tipo = tipo;
        this.descricao = descricao;
    }


    private String descricao = "", telefone;
    private Integer tipo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

                                                //Estava eu pensando num ternario pra deixar td em uma linha...
                                                //Quando entao ouvi uma misterisa voz em minha cabeca,
    public void imprimirContato(){              //e ela diza: "nao faca isso, se colega vai querer te matar".
        if (tipo == null){
            System.out.printf("Telefone: %s\nDescricao: %s\n\n", telefone, descricao);
        }else if (tipo == 1) {
            System.out.printf("Telefone: %s\nContato: Residencial\nDescricao: %s\n\n", telefone, descricao);
        }else if (tipo == 2){
            System.out.printf("Telefone: %s\nContato: Comercial\nDescricao: %s\n\n", telefone, descricao);
        }
    }
}
