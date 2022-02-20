package com.dbc;

public class ContaCorrente {
    public Cliente cliente = new Cliente();
    public String numeroConta;
    public Integer agencia;
    public Double saldo, chequeEspecial;

    public void imprimirContaCorrente(){
        if (cliente != null){
            cliente.imprimirCliente();
        }
        System.out.printf("Conta:   \t\t\t%s\n" +
                "Agencia: \t\t\t%d\n" +
                "Saldo:   \t\t\t%f\n" +
                "Cheque Espercial:\t%f\n\n",
                numeroConta, agencia, saldo, chequeEspecial);
    }
    public Boolean sacar(Double valor){
        return null;
    }
    public Boolean depositar(Double valor){
        return null;
    }
    public Double retornarSaldoComChequeEspecial(){
        return null;
    }
    public Boolean transferir(ContaCorrente contaCorrente, Double valor){
        return null;
    }
}
