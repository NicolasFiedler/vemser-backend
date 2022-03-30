package br.com.dbc.vemser.pessoaapi.dto.pessoa;

import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoDTO;
import lombok.Data;


import java.util.List;

@Data
public class PessoaDTOComContatos extends PessoaDTO{
    private List<ContatoDTO> contatos;
}
