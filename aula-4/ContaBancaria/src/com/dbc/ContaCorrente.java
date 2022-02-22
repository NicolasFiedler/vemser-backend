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


    private Cliente cliente;
    private String numeroConta;
    private Integer agencia = 1111;
    private Double saldo, chequeEspecial = 200., valorChequeEspecial = chequeEspecial;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

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
