package com.dbc;

import java.util.Scanner;

public class Main {

    private static ContaCorrente conta1, conta2;
    private static ContaPoupanca conP1;
    private static ContaDePagamento contaPagamento;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Construtores nao usados no momento sao restos da bateria de testes.

        start();

        contaPagamento.imprimir();
        pressEnter();

        //DEMONSTRACAO DE SAQUES

        System.out.println("SAQUE DE R$ 100,00\n");
        contaPagamento.sacar(100.);
        contaPagamento.imprimir();
        pressEnter();

        System.out.println("SAQUE DE R$ 500,00\n");
        contaPagamento.sacar(500.);
        contaPagamento.imprimir();
        pressEnter();

        System.out.println("SAQUE DE R$ 10,00\n");
        contaPagamento.sacar(10.);
        contaPagamento.imprimir();
        pressEnter();

        System.out.println("(tentativa) SAQUE DE R$ 100,00\n");
        if (!conta1.sacar(100.)){
            System.out.println("Saldo insuficiente.");
        }
        contaPagamento.imprimir();
        pressEnter();

        //DEMONSTRACAO DE DEPOSITOS

        System.out.println("DEPOSITO DE R$ 90,00\n");
        contaPagamento.depositar(90.);
        contaPagamento.imprimir();
        pressEnter();

        System.out.println("DEPOSITO DE R$ 230,00\n");
        contaPagamento.depositar(230.);
        contaPagamento.imprimir();
        pressEnter();

        //DEMONSTRACAO DE TRANSFERENCIA

        System.out.println("OBSERVER O ESTADO ATUAL DA CONTA #1\n");
        contaPagamento.imprimir();
        pressEnter();
        System.out.println("OBSERVER O ESTADO ATUAL DA CONTA #2\n");
        conta2.imprimir();
        pressEnter();

        System.out.println("TRANSFERENCIAS DE R$ 130,00 DA CONTA #1 PARA #2\n");
        contaPagamento.transferir(conta2,130.);
        contaPagamento.imprimir();
        pressEnter();

        System.out.println("TRANSFERENCIAS DE R$ 130,00 DA CONTA #1 PARA #2\n");
        conta2.imprimir();
        pressEnter();

        //TRANSFERENCIA CONTA POUPANCA PARA CONRRENTE

        System.out.println("OBSERVER O ESTADO ATUAL DA CONTA #1\n");
        conP1.imprimir();
        pressEnter();
        System.out.println("OBSERVER O ESTADO ATUAL DA CONTA #2\n");
        conta2.imprimir();
        pressEnter();

        System.out.println("TRANSFERENCIAS DE R$ 100,00 DA CONTA #1 PARA #2\n");
        conP1.transferir(conta2,100.);
        conP1.imprimir();
        pressEnter();

        System.out.println("TRANSFERENCIAS DE R$ 100,00 DA CONTA #1 PARA #2\n");
        conta2.imprimir();
    }

    public static void start(){
        //Gerando conta 1
        conta1 = new ContaCorrente("Mateus",
                                   "123.456.789-00",
                                   "12345678-9",
                                   "0001", 500., 200.);
        conta1.getCliente().getContatos().add(new Contato("91234-1234", 1, "Se nao atender, deixar recado."));
        conta1.getCliente().getEnderecos().add(new Endereco());

        //Gerando conta 2
        conta2 = new ContaCorrente("Jorge",
                "987.654.321-00",
                "98765432-1",
                "0001", 500., 200.);
        conta2.getCliente().getContatos().add(new Contato("94321-4321",
                2,
                "Atendemos das 8:00 as 17:00"));
        conta2.getCliente().getContatos().add(new Contato("94321-1234",
                1,
                ""));
        conta2.getCliente().getEnderecos().add(new Endereco());

        //Gerando conta poupanca
        conP1 = new ContaPoupanca("Lucas",
                "xxx.xxx.xxx-xx",
                "555555-1",
                "0001", 500.);
        conP1.getCliente().getContatos().add(new Contato("94321-4321",
                2,
                "aquele do sobrenome dificil"));
        conP1.getCliente().getContatos().add(new Contato("94321-1234",
                1,
                ""));
        conP1.getCliente().getEnderecos().add(new Endereco());

        //Gerando conta de pagamento
        contaPagamento = new ContaDePagamento("Cleo",
                "yyy.yyy.yyy-yy",
                "666666-1",
                "0001", 700.);
        contaPagamento.getCliente().getContatos().add(new Contato("94321-4321",
                2,
                "aquele do sobrenome dificil"));
        contaPagamento.getCliente().getContatos().add(new Contato("94321-1234",
                1,
                ""));
        contaPagamento.getCliente().getEnderecos().add(new Endereco());
    }

    public static void pressEnter(){
        System.out.println("\n Pressione [ENTER] x 2 para continuar.");
        scanner.nextLine();
        scanner.nextLine();
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
