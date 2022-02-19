package com.dbc;

public class Main {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.nome = "nicolas";
        pessoa1.sobrenome = "fiedler";
        pessoa1.idade = 24;
        pessoa1.whatsapp = "2342342341";

        Pessoa pessoa2 = new Pessoa();
        pessoa2.nome = "lucas";
        pessoa2.sobrenome = "kaAlgumaCoisa";
        pessoa2.idade = 19;
        pessoa2.whatsapp = "236197890890";

        pessoa1.conversar(pessoa2);
        pessoa2.retornaNomeCompleto();
        if (pessoa1.ehMaiorDeIdade()){
            System.out.println("Eh maior de idade");
        }else {
            System.out.println("Nao eh maior de idade");
        }
        pessoa2.mandarWhatsapp(pessoa1, "oi");
    }
}
