package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public List<EnderecoDTO> list() {
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .toList();
    }

    public EnderecoDTO getById(Integer id) throws Exception {
        return objectMapper.convertValue(list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não encontrado.")), EnderecoDTO.class);
    }

    public List<EnderecoDTO> getByPessoa(Integer id) throws Exception {
        return list().stream()
                .filter(e -> e.getIdPessoa().equals(id))
                .map(e -> objectMapper.convertValue(e, EnderecoDTO.class))
                .toList();
    }

    public EnderecoDTO create(Integer id, EnderecoCreateDTO endereco) {
        endereco.setIdPessoa(id);
        return objectMapper.convertValue(enderecoRepository.create(objectMapper.convertValue(endereco, Endereco.class)), EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO endereco) throws Exception {
        return objectMapper.convertValue(enderecoRepository.update(id, objectMapper.convertValue(endereco, Endereco.class)), EnderecoDTO.class);
    }

    public EnderecoDTO delete(Integer id) throws Exception {
        return objectMapper.convertValue(enderecoRepository.delete(id), EnderecoDTO.class);
    }

}
