package br.com.dbc.vemser.pessoaapi.entity;

public class Endereco {

    private String endereco, cidade;
    private Integer numero, id, idPessoa;

    public Endereco(){}

    public Endereco(Integer id, Integer idPessoa, String endereco, Integer numero, String cidade) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.endereco = endereco;
        this.cidade = cidade;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
