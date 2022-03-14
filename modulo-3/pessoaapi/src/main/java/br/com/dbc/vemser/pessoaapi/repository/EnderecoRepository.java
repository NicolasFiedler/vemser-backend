package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private static List<Endereco> enderecoList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository () {
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 1, "rua sla", 50, "fim de mundo"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 1, "av. 50", 7564, "fim de mundo"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 2, "av. 40", 26, "fim de mundo"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 3, "av. 80", 78, "fim de mundo"));
    }

    public Endereco create (Endereco endereco) {
        endereco.setId(COUNTER.incrementAndGet());
        enderecoList.add(endereco);
        return endereco;
    }

    public Endereco update (Integer id, Endereco endereco) throws Exception {
        Endereco resultEndereco = enderecoList.stream()
                .filter(endereco1 -> endereco1.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco nao encontrado."));
        resultEndereco = endereco;
        return resultEndereco;
    }

    public List<Endereco> list() {
        return enderecoList;
    }

    public Endereco delete(Integer id) throws Exception {
        Endereco endereco = enderecoList.stream()
                .filter(endereco1 -> endereco1.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco nao encontrado."));
        enderecoList.remove(endereco);
        return endereco;
    }
}
