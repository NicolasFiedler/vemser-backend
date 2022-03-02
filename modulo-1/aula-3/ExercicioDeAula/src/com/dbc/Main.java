package com.dbc;

public class Main {

    public static void main(String[] args) {
//        Pessoa pessoa1 = new Pessoa();
//        pessoa1.setNome("nicolas");
//        pessoa1.setSobrenome("fiedler");
//        pessoa1.setIdade(24);
//        pessoa1.setWhatsapp("2342342341");

        Pessoa pessoa1 = new Pessoa("nicolas", "fiedler", 24);
        pessoa1.setWhatsapp("2342342341");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("lucas");
        pessoa2.setSobrenome("kaAlgumaCoisa");
        pessoa2.setIdade(19);
        pessoa2.setWhatsapp("236197890890");

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
