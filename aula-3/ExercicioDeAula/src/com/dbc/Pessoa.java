package com.dbc;

public class Pessoa {

    public Pessoa(){}
    public Pessoa(String nome, String sobrenome, Integer idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    private String nome, sobrenome, whatsapp;
    private Integer idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void conversar(Pessoa destinatario){
        System.out.println(nome + " conversou com " + destinatario.nome);
    }
    public String retornaNomeCompleto(){
        return nome + " " + sobrenome;
    }
    public Boolean ehMaiorDeIdade(){
        if (idade >= 18) {
            return true;
        }
        return false;
    }
    public void mandarWhatsapp (Pessoa destinatario, String mensagem){
        System.out.println(nome + " enviou: " + mensagem + " para " + destinatario.nome);
    }
}
