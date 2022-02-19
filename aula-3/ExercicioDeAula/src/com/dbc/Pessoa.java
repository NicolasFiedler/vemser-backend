package com.dbc;

public class Pessoa {
    public String nome, sobrenome, whatsapp;
    public Integer idade;

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
