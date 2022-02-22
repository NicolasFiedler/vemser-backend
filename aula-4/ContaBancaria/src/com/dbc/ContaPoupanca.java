package com.dbc;

public class ContaPoupanca extends Conta implements Impressao{

    private static final Double JUROS_MENSAL = 1.01;

    public void creditarTaxa () {
        setSaldo(getSaldo()*JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        //todo montar o imprimir da poupanca;
    }
}
