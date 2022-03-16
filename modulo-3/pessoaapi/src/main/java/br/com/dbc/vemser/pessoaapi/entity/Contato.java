package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contato {
    private Integer id;
    private Integer idPessoa;
    @NotNull
    private String tipo;
    @NotEmpty
    @Max(13)
    private String numeroTelefone;

//    public Contato(){}
//
//    public Contato(Integer id, Integer idPessoa, String tipo, String numeroTelefone) {
//        this.setId(id);
//        this.setIdPessoa(idPessoa);
//        this.setTipo(tipo);
//        this.setNumeroTelefone(numeroTelefone);
//    }

//    public String getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getIdPessoa() {
//        return idPessoa;
//    }
//
//    public void setIdPessoa(Integer idPessoa) {
//        this.idPessoa = idPessoa;
//    }
//
//    public String getNumeroTelefone() {
//        return numeroTelefone;
//    }
//
//    public void setNumeroTelefone(String numeroTelefone) {
//        this.numeroTelefone = numeroTelefone;
//    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", idPessoa=" + idPessoa +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                '}';
    }
}