package br.com.dbc.vemser.pessoaapi.entity;

public class Contato {
    private Integer id;
    private Integer idPessoa;
    private String numeroTelefone;

    public Contato(){}

    public Contato(Integer id, Integer idPessoa, String numeroTelefone) {
        this.setId(id);
        this.setIdPessoa(idPessoa);
        this.setNumeroTelefone(numeroTelefone);
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

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", idPessoa=" + idPessoa +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                '}';
    }
}