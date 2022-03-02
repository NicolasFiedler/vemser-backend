package com.dbc;

public class ContaDePagamento extends Conta implements Impressao{
    private final static Double TAXA_SAQUE = 4.25;

    public ContaDePagamento(String nome, String cpf, String numeroConta, String agencia, Double saldo) {
        super(nome, cpf, numeroConta, agencia, saldo);
    }

    @Override
    public Boolean sacar (Double valor){
        if (valor + TAXA_SAQUE <= getSaldo() && valor > 0){
            valor += TAXA_SAQUE;
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public void imprimir() {
        System.out.printf("Conta:   \t\t\t%s\n" +
                        "Agencia: \t\t\t%s\n" +
                        "Saldo:   \t\t\tR$ %.2f\n" +
                        "Taxa de saque: \t\tR$ %.2f\n\n",
                getNumeroConta(), getAgencia(), getSaldo(), TAXA_SAQUE);
        if (getCliente() != null){
            getCliente().imprimirCliente();
        }
    }
}
