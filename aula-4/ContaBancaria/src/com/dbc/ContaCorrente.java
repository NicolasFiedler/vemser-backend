package com.dbc;

public class ContaCorrente extends Conta implements Impressao{

    private Double chequeEspecial;

    public ContaCorrente(String nome, String cpf, String numeroConta, String agencia, Double saldo, Double chequeEspecial) {
        super(nome, cpf, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public Double getChequeEspecial() {
        return chequeEspecial;
    }
    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void imprimir(){
        System.out.printf("Conta:   \t\t\t%s\n" +
                          "Agencia: \t\t\t%s\n" +
                          "Saldo:   \t\t\tR$ %.2f\n" +
                          "Cheque Espercial:\tR$ %.2f\n\n",
                getNumeroConta(), getAgencia(), getSaldo(), getChequeEspecial());
        if (getCliente() != null){
            getCliente().imprimirCliente();
        }
    }

    @Override
    public Boolean sacar(Double valor){
        if (valor <= retornarSaldoComChequeEspecial() && valor > 0){
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    public Double retornarSaldoComChequeEspecial(){
        return getSaldo() + chequeEspecial;
    }
}
