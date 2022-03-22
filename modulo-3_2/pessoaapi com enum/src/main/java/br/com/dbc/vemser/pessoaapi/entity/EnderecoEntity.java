package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enuns.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "endereco_pessoa")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "tipo")
    private Tipo tipo;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;

//    id_endereco NUMBER NOT NULL,
//    tipo NUMBER NOT NULL,
//    logradouro VARCHAR2(200) NOT NULL,
//    numero NUMBER NOT NULL,
//    complemento VARCHAR2(200) NULL,
//    cep VARCHAR2(8) NOT NULL,
//    cidade VARCHAR2(300) NOT NULL,
//    estado VARCHAR2(100) NOT NULL,
//    pais VARCHAR2(100) NOT NULL,
//    PRIMARY KEY(id_endereco)
}
