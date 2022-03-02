package com.dbc;

public class ContaPoupanca extends Conta implements Impressao{

    private static final Double JUROS_MENSAL = 1.01;

    public ContaPoupanca(String nome, String cpf, String numeroConta, String agencia, Double saldo) {
        super(nome, cpf, numeroConta, agencia, saldo);
        creditarTaxa();
    }

    public void creditarTaxa () {
        setSaldo(getSaldo()*JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.printf("Conta:   \t\t\t%s\n" +
                        "Agencia: \t\t\t%s\n" +
                        "Saldo:   \t\t\tR$ %.2f\n\n",
                getNumeroConta(), getAgencia(), getSaldo());
        if (getCliente() != null){
            getCliente().imprimirCliente();
        }
    }
}
