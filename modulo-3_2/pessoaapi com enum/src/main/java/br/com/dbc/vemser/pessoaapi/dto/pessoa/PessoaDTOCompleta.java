package br.com.dbc.vemser.pessoaapi.dto.pessoa;



import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import lombok.Data;

import java.util.List;

@Data
public class PessoaDTOCompleta extends PessoaDTO{
    private List<ContatoDTO> contatos;
    private List<EnderecoDTO> enderecos;
}
