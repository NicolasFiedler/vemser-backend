package br.com.dbc.vemser.pessoaapi.dto.contato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContatoDTO extends ContatoCreateDTO{
    private Integer idContato;
}
