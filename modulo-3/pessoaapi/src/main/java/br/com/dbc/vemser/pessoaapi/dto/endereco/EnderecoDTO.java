package br.com.dbc.vemser.pessoaapi.dto.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoDTO extends EnderecoCreateDTO {
    private Integer idEndereco;
}
