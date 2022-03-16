package br.com.dbc.vemser.pessoaapi.dto.pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDTO extends PessoaCreateDTO{
    private Integer idPessoa;
}
