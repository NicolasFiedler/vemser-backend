package com.dbc;

public class Endereco {
    public Endereco(){}
    public Endereco(String logradouro, Integer numero, String cidade, String estado, String pais, String cep, String complemento, Integer tipo){
        this.tipo = tipo;
        this.numero = numero;
        this.logradouro = logradouro;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.complemento = complemento;
    }
    public Endereco(String logradouro, Integer numero, String cidade, String estado, String pais, String cep, Integer tipo){
        this.tipo = tipo;
        this.numero = numero;
        this.logradouro = logradouro;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }


    private Integer tipo, numero;
    private String logradouro, pais, estado, cidade, cep, complemento = "";

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void imprimirEndereco(){                        //"Contato.java:16:49"
        if (!complemento.equals("")) {
            System.out.printf("Endereco: \n%s, %d.\nComplemento: %s.\n", logradouro, numero, complemento);
            System.out.printf("%s, %s, %s, %s.\n", cidade, estado, cep, pais);
        } else {
            System.out.printf("Endereco: %s, %d.\n", logradouro, numero);
            System.out.printf("%s, %s, %s, %s.\n", cidade, estado, cep, pais);
        }
        if (tipo == null){
        } else if (tipo == 1){
            System.out.println("Endereco residencial.");
        } else if (tipo == 2) {
            System.out.println("Endereco comercial.");
        }
        System.out.println("");
    }
}