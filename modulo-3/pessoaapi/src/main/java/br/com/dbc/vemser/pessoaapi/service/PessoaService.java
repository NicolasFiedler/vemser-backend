package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    ObjectMapper objectMapper;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO){
//        try{
//            if (StringUtils.isBlank(pessoa.getNome())) {
//                throw new Exception("Nome nao pode ficar em branco");
//            }
//            if (ObjectUtils.isEmpty(pessoa.getDataNascimento())) {
//                throw new Exception("Data de nascimento nao pode ficar em branco");
//            }
//            if (StringUtils.isBlank(pessoa.getCpf()) || (pessoa.getCpf().length() != 11 && StringUtils.isAlpha(pessoa.getCpf()))) {
//                throw new Exception("CPF invalido");
//            }
//
//            return pessoaRepository.create(pessoa);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
        Pessoa p = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);
        p = pessoaRepository.create(p);
        return objectMapper.convertValue(p, PessoaDTO.class);
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .toList();
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        Pessoa p = pessoaRepository.update(id, objectMapper.convertValue(pessoaAtualizar, Pessoa.class));
        return objectMapper.convertValue(p, PessoaDTO.class);
    }

    public PessoaDTO delete(Integer id) throws Exception {
        return objectMapper.convertValue(pessoaRepository.delete(id), PessoaDTO.class);
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .toList();
    }
}
