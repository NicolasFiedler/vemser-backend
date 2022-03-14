package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public Pessoa create(Pessoa pessoa){
        try{
            if (StringUtils.isBlank(pessoa.getNome())) {
                throw new Exception("Nome nao pode ficar em branco");
            }
            if (ObjectUtils.isEmpty(pessoa.getDataNascimento())) {
                throw new Exception("Data de nascimento nao pode ficar em branco");
            }
            if (StringUtils.isBlank(pessoa.getCpf()) || (pessoa.getCpf().length() != 11 && StringUtils.isAlpha(pessoa.getCpf()))) {
                throw new Exception("CPF invalido");
            }

            return pessoaRepository.create(pessoa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
