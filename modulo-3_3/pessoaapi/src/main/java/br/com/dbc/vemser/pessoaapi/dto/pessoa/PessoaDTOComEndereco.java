package br.com.dbc.vemser.pessoaapi.dto.pessoa;

import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import lombok.Data;

import java.util.List;

@Data
public class PessoaDTOComEndereco extends PessoaDTO {
    private List<EnderecoDTO> enderecos;
}
