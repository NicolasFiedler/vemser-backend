package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public ContatoDTO create (ContatoCreateDTO contato) {
        return objectMapper.convertValue(contatoRepository.save(objectMapper.convertValue(contato, ContatoEntity.class)), ContatoDTO.class);
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll().stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .toList();
    }

    public ContatoDTO update (Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        return contatoRepository.findById(id)
                .map(contatoEntity -> {

                    contatoEntity.setNumeroTelefone(contatoAtualizar.getNumeroTelefone());
                    contatoEntity.setDescricao(contatoAtualizar.getDescricao());
                    contatoEntity.setTipo(contatoAtualizar.getTipo());
                    contatoRepository.save(contatoEntity);

                    return objectMapper.convertValue(contatoEntity, ContatoDTO.class);

                })
                .orElseThrow(() -> new RegraDeNegocioException("Contato nao encontrado"));
    }

    public ContatoDTO delete (Integer id) throws Exception {
        ContatoDTO contatoDTO = contatoRepository.findById(id)
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .orElseThrow(() -> new RegraDeNegocioException("Contato nao encontrado"));
        contatoRepository.deleteById(id);
        return contatoDTO;
    }

    public List<ContatoDTO> listByPessoaId(Integer id) {
        return contatoRepository.findAll().stream()
                .filter(contatoEntity -> contatoEntity.getIdPessoa().equals(id))
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .toList();
    }

}
