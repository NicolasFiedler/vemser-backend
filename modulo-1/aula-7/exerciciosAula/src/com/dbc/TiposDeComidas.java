package com.dbc;

import java.util.Arrays;

public enum TiposDeComidas {
    JAPONESA("japonesa", 50.),
    FAST_FOOD("fast food", 30.),
    TRADICIONAL("tradicional", 20.);

    private String tipo;
    private Double valor;

    TiposDeComidas(String tipo, Double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }

    public static TiposDeComidas valueOfByTipo(String str){
        return Arrays.stream(TiposDeComidas.values())
                .filter(t -> t.getTipo().equalsIgnoreCase(str))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return String.format("%s: R$ %.2f", tipo, valor);
    }
}
