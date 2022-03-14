package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco getById(Integer id) throws Exception {
        return list().stream()
                .filter(endereco -> endereco.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não encontrado."));
    }

    public List<Endereco> getByPessoa(Integer id) throws Exception {
        return list().stream()
                .filter(e -> e.getIdPessoa().equals(id))
                .toList();
    }

    public Endereco create(Integer id, Endereco endereco) {
        endereco.setIdPessoa(id);
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer id, Endereco endereco) throws Exception {
        return enderecoRepository.update(id, endereco);
    }

    public Endereco delete(Integer id) throws Exception {
        return enderecoRepository.delete(id);
    }

}
