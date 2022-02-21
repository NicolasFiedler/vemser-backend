package com.dbc;

public class ContaCorrente {
    public ContaCorrente(){
        cliente = new Cliente();
    }
    public ContaCorrente(String nome, String cpf, String numeroConta, Double saldo){
        cliente = new Cliente(nome, cpf);
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }


    public Cliente cliente;
    public String numeroConta;
    public Integer agencia = 1111;
    public Double saldo, chequeEspecial = 200., valorChequeEspecial = chequeEspecial;



    public void imprimirContaCorrente(){
        System.out.printf("Conta:   \t\t\t%s\n" +
                          "Agencia: \t\t\t%d\n" +
                          "Saldo:   \t\t\tR$ %.2f\n" +
                          "Cheque Espercial:\tR$ %.2f\n\n",
                numeroConta, agencia, saldo, chequeEspecial);
        if (cliente != null){
            cliente.imprimirCliente();
        }
    }

    public Boolean sacar(Double valor){
        if (valor > 0 && retornarSaldoComChequeEspecial() >= valor && saldo > 0){
            if (valor > saldo){
                Double valorTotal = valor;
                valor -= saldo;
                saldo -= valorTotal;
                chequeEspecial -= valor;
                return true;
            } else {
                saldo -= valor;
                return true;
            }
        } else if (saldo < 0 && chequeEspecial > 0 && valor <= chequeEspecial){
            saldo -= valor;
            chequeEspecial -= valor;
            return true;
        }
        return false;
    }

    public Boolean depositar(Double valor){
        if (valor > 0){
            if (saldo < 0){
                if (valor <= valorChequeEspecial - chequeEspecial){
                    chequeEspecial += valor;
                    saldo += valor;
                } else {
                    saldo = valor - (valorChequeEspecial - chequeEspecial);
                    chequeEspecial = valorChequeEspecial;
                }
            }else {
                saldo += valor;
                return true;
            }
        }
        return false;
    }

    public Double retornarSaldoComChequeEspecial(){
        if (saldo > 0){
            return saldo + chequeEspecial;
        } else {
            return chequeEspecial;
        }
    }

    public Boolean transferir(ContaCorrente destinatario, Double valor){
        if ((!this.numeroConta.equals(destinatario.numeroConta)) && this.sacar(valor)){
            if (destinatario.depositar(valor)){
                return true;
            }
        }
        return false;
    }
}
