package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private List<Contato> contatoList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository(){
        contatoList.add(new Contato(COUNTER.incrementAndGet(), 1, "9876543212"));
        contatoList.add(new Contato(COUNTER.incrementAndGet(), 2, "3452245725"));
        contatoList.add(new Contato(COUNTER.incrementAndGet(), 2, "4688579678"));
        contatoList.add(new Contato(COUNTER.incrementAndGet(), 3, "9875356730"));
    }

    public Contato create (Contato contato) {
        contato.setId(COUNTER.incrementAndGet());
        contatoList.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return contatoList;
    }

    public Contato update (Integer id, Contato contatoUpdate) throws Exception {
        Contato contatoRecuperado = contatoList.stream()
                .filter(contato -> contato.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato nao encontrado"));
        contatoRecuperado.setNumeroTelefone(contatoUpdate.getNumeroTelefone());
        return contatoRecuperado;
    }

    public void delete (Integer id) throws Exception {
        Contato contatoRecuperado = contatoList.stream()
                .filter(contato -> contato.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato nao encontrado"));
        contatoList.remove(contatoRecuperado);
    }

    public List<Contato> listByPessoaId(Integer id) {
        return contatoList.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}
