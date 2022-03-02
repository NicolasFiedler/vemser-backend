package com.dbc;

import java.util.ArrayList;

public class Cliente {

    public Cliente(){}
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }


    private String nome, cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void imprimirCliente(){
        System.out.printf("Nome: %s \nCpf: %s\n\n", nome, cpf);
        imprimirContatos();
        imprimirEnderecos();
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
        if (!flag){
            System.out.println("\n");
        }
    }
}

