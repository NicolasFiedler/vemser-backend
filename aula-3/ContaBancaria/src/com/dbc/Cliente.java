package com.dbc;

public class Cliente {
    public String nome, cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];

    public void imprimirCliente(){
        System.out.printf("Nome: %s \nCpf: %s\n\n", nome, cpf);
    }
    public void imprimirContatos(){
        Boolean flag = true;
        for (Contato contato : contatos) {
            if (contato == null){
                if (flag){
                    System.out.println("Nao ha contatos cadastrados");
                }
                break;
            }
            flag = false;
            contato.imprimirContato();
        }
    }
    public void imprimirEnderecos(){
        Boolean flag = true;
        for (Endereco endereco : enderecos) {
            if (endereco == null){
                if (flag){
                    System.out.println("Nao ha enderecos cadastrados");
                }
                break;
            }
            flag = false;
            endereco.imprimirEndereco();
        }
    }
}

