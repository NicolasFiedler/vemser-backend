package com.dbc;

import java.util.logging.SocketHandler;

public abstract class Conta implements Movimentacao {

    private Cliente cliente;
    private String numeroConta, agencia;
    private Double saldo;

    public Conta () {}
    public Conta(String nome, String cpf, String numeroConta, String agencia, Double saldo) {
        this.cliente = new Cliente(nome, cpf);
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

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

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public Boolean sacar (Double valor){
        if (valor <= saldo && valor > 0){
            saldo -= valor;
            return true;
        }
        return false;
    }
    @Override
    public Boolean depositar(Double valor){
        if (valor > 0){
            saldo += valor;
            return true;
        }
        return false;
    }
    @Override
    public Boolean transferir(Conta conta, Double valor){
        if ((!this.numeroConta.equals(conta.numeroConta)) && this.sacar(valor)){
            if (conta.depositar(valor)){
                return true;
            }
        }
        return false;
    }
}
