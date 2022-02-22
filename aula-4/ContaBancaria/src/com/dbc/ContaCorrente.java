package com.dbc;

public class ContaCorrente extends Conta implements Impressao{

    private Double chequeEspecial;

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
        }    }

    @Override
    public Boolean sacar(Double valor){
        if (valor <= retornarSaldoComChequeEspecial()){
            setSaldo(getSaldo() - valor);
        }
        return false;
    }

    public Double retornarSaldoComChequeEspecial(){
        return getSaldo() + chequeEspecial;
    }
}
