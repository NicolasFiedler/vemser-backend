package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService () {
        contatoRepository = new ContatoRepository();
    }

    public Contato create (Contato contato) {
        return contatoRepository.create(contato);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update (Integer id, Contato contato) throws Exception {
        return contatoRepository.update(id, contato);
    }

    public void delete (Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> listByPessoaId(Integer id) {
        return contatoRepository.listByPessoaId(id);
    }

}
