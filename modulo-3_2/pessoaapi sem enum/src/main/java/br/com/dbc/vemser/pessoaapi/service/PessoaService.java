package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO){

        PessoaEntity p = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        pessoaRepository.save(p);
//        if (p != null){
//            emailService.sendEmail(objectMapper.convertValue(p, PessoaDTO.class), "Novo Cadastro","email-template-cria-pessoa.ftl");
//        }
        return objectMapper.convertValue(p, PessoaDTO.class);
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.findAll().stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        return pessoaRepository.findById(id)
                        .map(pessoaEntity -> {

                            pessoaEntity.setNome(pessoaAtualizar.getNome());
                            pessoaEntity.setEmail(pessoaAtualizar.getEmail());
                            pessoaEntity.setCpf(pessoaAtualizar.getCpf());
                            pessoaEntity.setDataNascimento(pessoaAtualizar.getDataNascimento());
                            pessoaRepository.save(pessoaEntity);

                            return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

                        })
                        .orElseThrow(() -> new RegraDeNegocioException("Pessoa nao encontrada"));
    }

    public PessoaDTO delete(Integer id) throws Exception {
        PessoaDTO pessoaDTO = getPessoaById(id);
        pessoaRepository.deleteById(id);
        return pessoaDTO;
    }

//    public List<PessoaDTO> listByName(String nome) {
//        return pessoaRepository.findAll().stream()
//                .filter(pessoaEntity -> pessoaEntity.getNome().contains(nome))
//                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
//                .collect(Collectors.toList());
//    }

    public PessoaDTO getPessoaById (Integer id) throws Exception {
       return pessoaRepository.findById(id)
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .orElseThrow(() -> new RegraDeNegocioException("Pessa nao encontrada"));
    }
}
