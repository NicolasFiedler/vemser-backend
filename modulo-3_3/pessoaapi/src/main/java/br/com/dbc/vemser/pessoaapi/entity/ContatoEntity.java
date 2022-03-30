package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enuns.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;

    @Column(name = "id_pessoa", insertable = false, updatable = false)
    private Integer idPessoa;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "tipo")
    private Tipo tipo;

    @Column(name = "numero")
    private String numeroTelefone;

    @Column(name = "descricao")
    private String descricao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoaEntity;
}