package com.dbc;

public class Subtracao implements OperacaoMatematica {
    @Override
    public Integer calcula(Integer a, Integer b) {
        return a - b;
    }
}
