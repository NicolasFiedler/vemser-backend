package com.dbc;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private ContaCorrente cliente1, cliente2;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


//        Cliente cliente = new Cliente();
//
//        Endereco endereco = new Endereco();
//
//       // cliente.enderecos[0] = endereco;
//        cliente.imprimirContatos();
//        cliente.imprimirCliente();
//        cliente.imprimirEnderecos();

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.imprimirContaCorrente();
    }

    public void start(){
        //Gerando conta 1
        cliente1 = new Cliente();

        cliente1.
    }

    public void pressEnter(){
        System.out.println("\n Pressione [ENTER] para continuar.");
        scanner.nextLine();
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}
