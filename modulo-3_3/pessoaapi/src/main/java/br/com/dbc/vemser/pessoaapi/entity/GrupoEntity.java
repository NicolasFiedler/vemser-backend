package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "GRUPO")
public class GrupoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grupo")
    @SequenceGenerator(name = "seq_grupo", sequenceName = "seq_grupo", allocationSize = 1)
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;
                                        //TODO - conferir se a relacao n dara problema

    @ManyToMany(mappedBy = "grupos")
    private List<UsuarioEntity> usuarios;

    @ManyToMany
    @JoinTable(
            name = "GRUPO_REGRA",
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_regra")
    )
    private Set<RegraEntity> regras;



}
