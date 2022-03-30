package br.com.dbc.vemser.pessoaapi.enuns;

import java.util.Arrays;

public enum Tipo {
    RESIDENTIAL(0),
    BUSINESS(1);

    private Integer type;

    Tipo(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static Tipo ofType(Integer type) {
        return Arrays.stream(Tipo.values())
                .filter(tp -> tp.getType().equals(type))
                .findFirst()
                .get();
    }
}